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
        imagePath = "Images/door/doorClose.png";
        getImage();

    }

    public void reactToCollision(MovableCharacter mc) {
        //change the point checker as much as cheese you will make to end the game after collecting all the cheese
        if(gp.points >= 3) {
            gp.isGameOver = true;
        }
    }
}

