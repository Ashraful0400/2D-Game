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
            moveUp();
        } else if (keyboardInput.leftKeyPressed) {
            moveLeft();
        } else if (keyboardInput.downKeyPressed) {
            moveDown();
        } else if (keyboardInput.rightKeyPressed) {
            moveRight();
        }
        CollisionOn = false;
        //gp.cChecker.processObjectCollision(this);
        resetHitboxPos();
    }

    private void moveUp() {
        imagePath = "Images/mouse/mouseBack .png"; // TODO - space in images file
        getImage();
        y -= speed;
    }
    private void moveLeft() {
        if (imagePath == "Images/mouse/mouseLeft.png") {
            imagePath = "Images/mouse/mouseLeft2.png";
        } else {
            imagePath = "Images/mouse/mouseLeft.png";
        }
        getImage();
        x -= speed;
    }
    private void moveDown() {
        imagePath = "Images/mouse/mouseForward.png";
        getImage();
        y += speed;
    }
    private void moveRight() {
        if (imagePath == "Images/mouse/mouseRight.png") {
            imagePath = "Images/mouse/mouseRight2.png";
        } else {
            imagePath = "Images/mouse/mouseRight.png";
        }
        getImage();
        x += speed;
    }
    

    public void repaint(Graphics g) {
        if (gp.isGameOver) {
            imagePath = "Images/mouse/mouseDie.png";
            getImage();
        }
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(sprite,x,y,gp.tileSize, gp.tileSize, null);
    }

}
//whereever you use update neeed to change from video 6 at 10:15 from ashraf (gp.checker) and also update at min 21