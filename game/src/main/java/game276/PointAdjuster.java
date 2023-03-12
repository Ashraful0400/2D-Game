package game276;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.*;

public abstract class PointAdjuster extends StageGameObject{

    protected int _amountToAdjust;

    public BufferedImage image;

    public GamePanel gp;

    public PointAdjuster(GamePanel gp, int x, int y){
        this.gp = gp;
        this.x = x;
        this.y = y;
       
        hitboxLength = gp.tileSize;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);

        this._amountToAdjust = -1;// -1: amount not assign

    }

    public int adjustPoints(){
        return _amountToAdjust;
    }

    public void reactToCollision(MovableCharacter mc) {
        if (mc == gp.player) {
            gp.points += adjustPoints();
            gp.allObjectLst.remove(this);
        }
    }


    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(sprite, x,y,gp.tileSize,gp.tileSize,null);
    }

    

}
