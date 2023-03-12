package game276;
import java.awt.*;

public class Barrier extends StageGameObject {
    Barrier (GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        this.x = startingX;
        this.y = startingY;
       
        hitboxLength = gp.tileSize;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        imagePath = "Images/wall/wall.png";
        getImage();
    }


    public void reactToCollision(MovableCharacter mc) {
        mc.moveBack();
    }

    // Just draws a rectangle for now
    /*public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //g2D.setColor(Color.blue);
        //g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
    }*/
}
