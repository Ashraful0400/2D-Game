package game276;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Player {
    public int x;
    public int y; //y increase -> move downward
    public int speed;
    public GamePanel gp;

    public InputHandler input = new InputHandler();

    Player(GamePanel gp) {
        this.gp = gp;
        // Default positions
        this.x = 100;
        this.y = 100;
    }

    public void move() {
        if (input.upKeyPressed) {
            y -= speed;
        } else if (input.leftKeyPressed) {
            x -= speed;
        } else if (input.downKeyPressed) {
            y += speed;
        } else if (input.rightKeyPressed) {
            x += speed;
        }
    }

    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2D.dispose(); // Free resources related to g2D
    }

}
