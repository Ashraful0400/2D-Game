package game276;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * represents an object that can decrease the points
 */
public class StationaryEnemy extends PointAdjuster {
    /**
     * consturctor
     * @param gp game panel that the stationary enemy is on
     * @param x position of stationary enemy
     * @param y position of stationary enemy
     */
    public StationaryEnemy(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = -3;
        hitboxLength = gp.tileSize;
        imagePath = "Images/mouseTrap/mouseTrap.png";
        getImage();
    }

}
