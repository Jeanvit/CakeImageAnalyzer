package cake.components;

import cake.utils.ImageUtils;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Jean Vitor de Paulo (modified version of Special JPanel that loads an
 * image that can have a region selected
 * http://blog.sodhanalibrary.com/2015/04/select-rectangular-area-in-image-using.html#.Wf1F1GhSyUk)
 */
public class ImageViewer extends JPanel {

    private Image image;
    private Shape shape = null;
    private Point startDrag, endDrag;
    private Rectangle selectedRegion, originalImageRectangle;
    private PropertyChangeSupport support;
    private boolean clickForCancel = false; // Control if a click is for canceling the current selection

    public ImageViewer(BufferedImage inputImage, JPanel panel) throws IOException {
        if (inputImage == null) {
            return;
        }
        image = ImageUtils.getScaledImage(inputImage, panel.getWidth(), panel.getHeight());
        support = new PropertyChangeSupport(this);
        originalImageRectangle = new Rectangle(0, 0, image.getWidth(null), image.getHeight(null));
        this.setBounds(originalImageRectangle);

//        setLocation(150, 0);
        this.addMouseListener(new MouseAdapter() {

            //Single mouse click resets the selection
            public void mouseClicked(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
                cancelSelection();
                clickForCancel = true;

            }

            //While holding the left mouse button, update the regions
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }

            //When the mouse is released, probably the selection is done
            //Calculate the values, notify the selected
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (endDrag != null && startDrag != null) {
                    try {

                        if (x > image.getWidth(null)) {
                            x = image.getWidth(null) - 1;
                        }
                        if (y > image.getHeight(null)) {
                            y = image.getHeight(null) - 1;
                        }
                        shape = makeRectangle(startDrag.x, startDrag.y, x, y);
                        selectedRegion = new Rectangle(startDrag.x, startDrag.y, x, y);
                        startDrag = null;
                        endDrag = null;
                        select(selectedRegion);
                        repaint();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Please, select a region inside the panel", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //While dragging the mouse, show the animation and update the region
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
                clickForCancel = false;

                repaint();
            }
        });
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    //Warn the listeners that an select action just happened
    public void select(Rectangle rect) {
        support.firePropertyChange("selected", "rect", rect);
    }

    //Warn the listeners the "true" image was set to have the panel dimensions
    //for further calculations based on that
    public void trueImage(Image image) {
        support.firePropertyChange("trueImage", "image", ImageUtils.toBufferedImage(image));
    }

    //Warn the listeners that they should cancel the selection
    public void cancelSelection() {
        support.firePropertyChange("cancelSelection", "cancel", "");
    }

    public Rectangle getSelectedArea() {
        return this.selectedRegion;
    }

    /**
     * Function to handle the selection effect
     *
     * @param g a Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                0.50f));

        //Avoid drawing any shape on a single mouse click
        if (clickForCancel) {
            return;
        }
        if (shape != null) {
            g2.setPaint(Color.YELLOW);
            g2.draw(shape);
            g2.setPaint(Color.YELLOW);
            g2.fill(shape);
        }

        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.YELLOW);
            Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x,
                    endDrag.y);
            g2.draw(r);
        }
    }

    /**
     * Process a image to obtain its alpha channel
     *
     * @param int x1 - The initial X position
     * @param int x2 - The final X position
     * @param int y1 - The initial Y position
     * @param int y2 - The final Y position
     * @return new Rectangle2D.Float - The positions of the rectangle
     *
     */
    private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public int getComponentHeight() {
        return this.originalImageRectangle.height;
    }

    public int getComponentWidth() {
        return this.originalImageRectangle.width;
    }

}
