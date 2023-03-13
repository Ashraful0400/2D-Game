package game276;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * handles input from player
 */
public class InputHandler implements KeyListener {
    /**
     * keys that handler cares about
     */
    public boolean upKeyPressed;
    public boolean downKeyPressed;
    public boolean leftKeyPressed;
    public boolean rightKeyPressed;

    public boolean EnterPressed;

    /**
     * react to key that typed
     * now: nothing to happen
     * @param E the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent E) {

    }

    /**
     * react when key is pressed
     * for detecting which direction player wants
     * main character to be
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();

        if (input == KeyEvent.VK_W) {
            System.out.println("W");
            upKeyPressed = true;
        } else if (input == KeyEvent.VK_A) {
            leftKeyPressed = true;
        } else if (input == KeyEvent.VK_S) {
            downKeyPressed = true;
        } else if (input == KeyEvent.VK_D) {
            rightKeyPressed = true;
        } else if (input == KeyEvent.VK_ENTER){
            EnterPressed = true;
        }
    }

    /**
     * reacts to key when it is released
     * for detect a stop for main character
     * @param e the event to be processed
     */
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
        } else if (input == KeyEvent.VK_ENTER){
            EnterPressed = false;
        }
    }

    
}
