package game276;

import java.awt.*;

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
        hitboxLength = 14;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        imagePath = "Images/cheese/cheese.png";
        getImage();
    }

    public void reactToCollision(MovableCharacter mc) {
        super.reactToCollision(mc);
        gp.spawner.ordinaryRewardNum--;
    }


}
