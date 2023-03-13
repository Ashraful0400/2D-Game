package game276;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;

/**
 * this class creates regular reward that increase the points
 */
public class Reward extends PointAdjuster{

    /**
     * Constructor
     * @param gp game panel that the reward will be placed
     * @param x x coordinate for reward on the game
     * @param y y coordinate for reward on the game
     */
    public Reward(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = 3;
        imagePath = "Images/cheese/cheese.png";
        getImage();
    }

}
