package game276;


import game276.GamePanel;
import game276.MovableCharacter;
import game276.StageGameObject;
import game276.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

import java.awt.*;

public class ExitCell extends StageGameObject {
    public ExitCell(GamePanel gp, int x, int y) {
        this.gp = gp;
        this.x = x;
        this.y = y;
       
        hitboxLength = 10;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        try {
            //possible error
            sprite = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }


}

