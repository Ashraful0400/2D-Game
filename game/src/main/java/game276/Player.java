package game276;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;

import java.io.File;

public class Player extends MovableCharacter {
    public InputHandler keyboardInput = new InputHandler();

    public Player(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        imagePath = "Images/mouse/mouseForward.png";
        this.speed = 5;
        this.getImage();

    }

    public void move() {

        prevX = x;
        prevY = y;
        
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
        resetHitboxPos();
    }

    // Just draws a rectangle for now
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //g2D.setColor(Color.white);
        //g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2D.drawImage(sprite,x,y,gp.tileSize, gp.tileSize, null);
    }

}
//whereever you use update neeed to change from video 6 at 10:15 from ashraf (gp.checker) and also update at min 21