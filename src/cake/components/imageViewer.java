/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cake.components;

import cake.classes.ImageUtils;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 * Special JPanel that loads an image that can have a region selected
 *
 * @author Jean Vitor de Paulo (modified version of
 * http://blog.sodhanalibrary.com/2015/04/select-rectangular-area-in-image-using.html#.Wf1F1GhSyUk)
 */
public class ImageViewer extends JPanel {

    private BufferedImage image;
    private Shape shape = null;
    private Point startDrag, endDrag;
    private Rectangle selectedRegion;
    private int startX = 0, startY = 0;
    private PropertyChangeSupport support;

    public ImageViewer(BufferedImage inputImage, JPanel panel) throws IOException {
        if (inputImage == null) {
            return;
        }
        image = inputImage;
        image = ImageUtils.getScaledImage(image, panel.getWidth(), panel.getHeight());
        support = new PropertyChangeSupport(this);

        this.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
                cancelSelection();
            }

            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (endDrag != null && startDrag != null) {
                    try {
                        shape = makeRectangle(startDrag.x, startDrag.y, x, y);
//                        System.out.println(startDrag.x + " " + startDrag.y + " " + x + " " + y);
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

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
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

    public void select(Rectangle rect) {
        support.firePropertyChange("selected", "rect", rect);
    }

    public void cancelSelection() {
        support.firePropertyChange("cancelSelection", "cancel", "");
    }

    public Rectangle getSelectedArea() {
        return this.selectedRegion;
    }

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

        if (shape != null) {
            g2.setPaint(Color.BLACK);
            g2.draw(shape);
            g2.setPaint(Color.YELLOW);
            g2.fill(shape);
        }

        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.LIGHT_GRAY);
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

}
