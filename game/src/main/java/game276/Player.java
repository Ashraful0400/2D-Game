package game276;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Player extends MovableCharacter {
    
    public InputHandler keyboardInput = new InputHandler();

    Player(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        this.speed = 5;
    }

    public void move() {
        if (keyboardInput.upKeyPressed) {
            y -= speed;
        } else if (keyboardInput.leftKeyPressed) {
            x -= speed;
        } else if (keyboardInput.downKeyPressed) {
            y += speed;
        } else if (keyboardInput.rightKeyPressed) {
            x += speed;
        }
    }

    // Just draws a rectangle for now, Replace with super class method that will draw a sprite
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2D.dispose(); // Free resources related to g2D
    }

}
