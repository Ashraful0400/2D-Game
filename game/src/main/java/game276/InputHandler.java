package game276;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean upKeyPressed;
    public boolean downKeyPressed;
    public boolean leftKeyPressed;
    public boolean rightKeyPressed;

    @Override
    public void keyTyped(KeyEvent E) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();

        if (input == KeyEvent.VK_W) {
            System.out.println("W");
            upKeyPressed = true;
        } else if (input == KeyEvent.VK_A) {
            System.out.println("A");
            leftKeyPressed = true;
        } else if (input == KeyEvent.VK_S) {
            System.out.println("S");
            downKeyPressed = true;
        } else if (input == KeyEvent.VK_D) {
            System.out.println("D");
            rightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();

        if (input == KeyEvent.VK_W) {
            upKeyPressed = false;
        } else if (input == KeyEvent.VK_A) {
            leftKeyPressed = false;
        } else if (input == KeyEvent.VK_S) {
            downKeyPressed = false;
        } else if (input == KeyEvent.VK_D) {
            rightKeyPressed = false;
        }
    }

    
}
