package game276;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StationaryEnemy extends PointAdjuster {

    public StationaryEnemy(GamePanel gp, int x, int y){
        super(gp, x, y);
        this._amountToAdjust = -3;
        imagePath = "Images/mouseTrap/mouseTrap.png";
        getImage();
    }

}
