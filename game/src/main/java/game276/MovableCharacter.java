package game276;

import java.awt.*;

/**
 * this class represents all movable objects
 */
public abstract class MovableCharacter extends StageGameObject {
    /**
     * setting for each character
     */
    public int speed; // How much character moves each frame
    public GamePanel gp;
    public String name;
    public String direction;
    // Needed for moveBack()
    public int prevX;
    public int prevY;
    /**
     * Constructor
     * @param gp game panel that the character will be placed
     * @param startingX original x coordinate for character on the game
     * @param startingY original y coordinate for character on the game
     */
    public MovableCharacter(GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        this.x = startingX;
        this.y = startingY;
        hitboxLength = 19;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
    }

    /**
     *  set up hit box for collision detector
     */
    public void resetHitboxPos() {
        hitBox.x = x;
        hitBox.y = y;
    }

    /**
     * moves character to next position
     */
    public void move() {};

    /**
     * takes character to the position
     * they were at the previous tick
     */
    public void moveBack() {
        x = prevX;
        y = prevY;
    }
}
