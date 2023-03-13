package game276;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;

import java.io.File;

/**
 * represents object that is controled by player
 *
 */
public class Player extends MovableCharacter {
    /**
     * handler for player input
     */
    public InputHandler keyboardInput = new InputHandler();

    /**
     * Constructor
     * @param gp game panel that the main character will be placed
     * @param startingX original x coordinate for main character on the game
     * @param startingY original y coordinate for main character on the game
     */
    public Player(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        imagePath = "Images/mouse/mouseForward.png";
        this.speed = 5;
        this.getImage();

    }

    /**
     * move main character base on player input
     */
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

    /**
     * move up and change image
     */
    private void moveUp() {
        imagePath = "Images/mouse/mouseBack .png"; // TODO - space in images file
        getImage();
        y -= speed;
    }
    /**
     * move left and change image
     */
    private void moveLeft() {
        if (imagePath == "Images/mouse/mouseLeft.png") {
            imagePath = "Images/mouse/mouseLeft2.png";
        } else {
            imagePath = "Images/mouse/mouseLeft.png";
        }
        getImage();
        x -= speed;
    }
    /**
     * move down and change image
     */
    private void moveDown() {
        imagePath = "Images/mouse/mouseForward.png";
        getImage();
        y += speed;
    }
    /**
     * move right and change image
     */
    private void moveRight() {
        if (imagePath == "Images/mouse/mouseRight.png") {
            imagePath = "Images/mouse/mouseRight2.png";
        } else {
            imagePath = "Images/mouse/mouseRight.png";
        }
        getImage();
        x += speed;
    }

    /**
     * drawing main character on the game window
     * @param g graphics for drawing main character
     */
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