package game276;
import java.awt.*;
/**
 * represents object that is controled by player
 *
 */
public class Player extends MovableCharacter {
    /**
     * handler for player input
     */
    public InputHandler keyboardInput;

    /**
     * Constructor
     * @param gp game panel that the main character will be placed
     * @param startingX original x coordinate for main character on the game
     * @param startingY original y coordinate for main character on the game
     */
    public Player(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        this.keyboardInput = gp.keyboardHandler;
        imagePath = "Images/mouse/mouseForward.png";
        this.speed = 5;
        this.getImage();
    }

    /**
     * move main character based on player input
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
        if (gp.didWinGame) { // MUST evaluate didWinGame first due to how StationaryEnemy is set up
            // Mouse hold cheese when he wins
            if (imagePath == "Images/mouse/mouseLeft.png" || imagePath == "Images/mouse/mouseLeft2.png") {
                imagePath = "Images/mouse/CheeseLeft";
            } else if (imagePath == "Images/mouse/mouseRight.png" || imagePath == "Images/mouse/mouseRight2.png") {
                imagePath = "Images/mouse/CheeseRight";
            }
        } else if (gp.gameState == gp.gameOverState) {
            imagePath = "Images/mouse/mouseDie.png";
        }
        getImage();
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(sprite,x,y,gp.tileSize, gp.tileSize, null);
    }

}
