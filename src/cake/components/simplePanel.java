package cake.components;

import cake.utils.ImageUtils;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * *
 * Class enabling a JPanel to show an image
 *
 * @author Jean Vitor de Paulo
 */
public class SimplePanel extends JPanel {

    Image image;
    public int width, height;

    public SimplePanel(BufferedImage bf, JPanel panel) {
        if (bf == null) {
            return;
        }
        image = ImageUtils.getScaledImage(bf, panel.getWidth(), panel.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}
