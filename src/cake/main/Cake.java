package cake.main;
import cake.screens.MainScreen;
/**
 *
 * @author Jean Vitor de Paulo
 * APP Main class
 */
public class Cake {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainScreen Main = new MainScreen();
        Main.setVisible(true);
        Main.setResizable(false);
    }
    
}
