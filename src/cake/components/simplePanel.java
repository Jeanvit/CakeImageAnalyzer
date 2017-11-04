package cake.components;

import cake.classes.ImageUtils;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * * 
 * Class enabling a JPanel to show an image
 * @author Jean Vitor de Paulo
 */
public class simplePanel extends JPanel{ 
    BufferedImage image;

//------------------------------------------------------------------------------------------ 
    public simplePanel(BufferedImage bf, JPanel panel){
        image=ImageUtils.getScaledImage(bf, panel.getWidth(), panel.getHeight());
    }
//------------------------------------------------------------------------------------------ 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
    }
}