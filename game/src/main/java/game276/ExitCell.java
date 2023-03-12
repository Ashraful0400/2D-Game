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
        // TODO - change the point checker as much as cheese you will make to end the game after collecting all the cheese
        // TODO - Need to change gameOver condition (bonusRewards also count)

        // TODO - Need to change so it WINS the game
        if (mc == gp.player && gp.points >= 3) {
            imagePath = "Images/door/doorOpen.png";
            getImage();
            gp.isGameOver = true;
        }
    }
}

