package game276;
import java.awt.*;

/**
 * this class represents an object that
 * blocks any movable character to move over it
 */
public class Barrier extends StageGameObject {
    /**
     * Constructor
     * @param gp game panel that the barrier will be placed
     * @param startingX x coordinate for barrier on the game
     * @param startingY y coordinate for barrier on the game
     */
    Barrier (GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        this.x = startingX;
        this.y = startingY;
       
        hitboxLength = gp.tileSize;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        imagePath = "Images/wall/wall.png";
        getImage();
    }

    /**
     * This method is going to push characters back
     * to where they are at the previous tick
     * @param mc the movable character that collide with this barrier
     */
    public void reactToCollision(MovableCharacter mc) {
        mc.moveBack();
    }


}
