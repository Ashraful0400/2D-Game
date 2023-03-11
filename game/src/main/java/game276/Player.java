package game276;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;

public class Player extends MovableCharacter {
    public InputHandler keyboardInput = new InputHandler();

    public Player(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);

        imagePath = "mouse/mouse1.png.png";
        getImage();
        this.speed = 5;
    }

    public void move() {
        if (keyboardInput.upKeyPressed) {
            direction = "up";
            y -= speed;
        } else if (keyboardInput.leftKeyPressed) {
            direction = "left";
            x -= speed;
        } else if (keyboardInput.downKeyPressed) {
            direction = "down";
            y += speed;
        } else if (keyboardInput.rightKeyPressed) {
            direction = "right";
            x += speed;
        }
        CollisionOn = false;
        //gp.cChecker.processObjectCollision(this);
    }

    // Just draws a rectangle for now
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

}
//whereever you use update neeed to change from video 6 at 10:15 from ashraf (gp.checker) and also update at min 21