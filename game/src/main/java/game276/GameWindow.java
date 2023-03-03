package game276;
import javax.swing.JFrame;

public class GameWindow {
    public void runGame() {
        JFrame gameWindow = new JFrame();

        // When user closes window, exit the entire program
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle("276 Game");

        GamePanel gp = new GamePanel();
        gameWindow.add(gp);
        gameWindow.pack(); // TODO - Resizes window?

        // Place window at middle of the screen
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        gp.startThread();
        
    }
    
}
