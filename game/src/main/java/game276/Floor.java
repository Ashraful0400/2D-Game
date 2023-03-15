package game276;
import java.awt.*;
import java.util.Random;

/**
 * this class represents an object that
 *  gives path to movable character to move over it
 */
public class Floor extends StageGameObject {
    /**
     * Constructor
     * @param gp game panel that the Floor will be placed
     * @param startingX x coordinate for Floor on the game
     * @param startingY y coordinate for Floor on the game
     */
    Floor (GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        this.x = startingX;
        this.y = startingY;

        hitboxLength = gp.tileSize;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        imagePath = "Images/floor/floor.png";
        int max = 4;
        Random x = new Random();
        int y = x.nextInt(max);
        /**if( y == 0 ){
            imagePath = "Images/floor/f1.png";
        }
        if( y == 1 ){
            imagePath = "Images/floor/f3.png";
        }
        if( y == 2 ){
            imagePath = "Images/floor/f2.png";
        }
        if( y == 3 ){
            imagePath = "Images/floor/f4.png";
        }*/
        getImage();
    }



}
