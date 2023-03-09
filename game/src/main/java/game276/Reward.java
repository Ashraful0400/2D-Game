package game276;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;

public class Reward extends PointAdjuster{

    protected int _amountToAdjust;

    public Reward(GamePanel gp, int _amountToAdjust, int x, int y){
        super(gp, _amountToAdjust, x, y);
        try{
            image = ImageIO.read(getClass().getResourceAsStream(null));//TODO image
        }catch (IOException e){
            e.printStackTrace();
        }
        this._amountToAdjust = _amountToAdjust;
    }

}
