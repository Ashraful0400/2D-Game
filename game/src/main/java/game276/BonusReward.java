package game276;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;

/**
 * This class represents an object
 * that adds more points on overall score
 */
public class BonusReward extends Reward{

    /**
     * Constructor
     * @param gp game panel that the bonus reward will be placed
     * @param x x coordinate for bonus reward on the game
     * @param y y coordinate for bonus reward on the game
     */
    public BonusReward(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = 5;
        hitboxLength = gp.tileSize;
        imagePath = "Images/cheese/bigCheese.png";
        getImage();
    }

}
