package cake;
import cake.screens.mainScreen;
import java.io.IOException;
import javax.swing.ImageIcon;
/**
 *
 * @author Jean Vitor de Paulo
 * APP Main class
 */
public class Cake {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        mainScreen Main = new mainScreen();
        Main.setVisible(true);
        ImageIcon img = new ImageIcon("iconCake.jpg");
        Main.setIconImage(img.getImage());
        Main.setResizable(false);
    }
    
}
