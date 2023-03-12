package game276;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.IOException;

public class Reward extends PointAdjuster{

    public Reward(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = 3;
        imagePath = "Images/cheese/cheese.png";
        getImage();
    }

}
