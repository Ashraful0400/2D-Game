package game276;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;

public class BonusReward extends Reward{

    public BonusReward(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = 5;
        /* try{
            image = ImageIO.read(getClass().getResourceAsStream(null));//TODO image
        }catch (IOException e){
            e.printStackTrace();
        } */
    }

}
