package game276;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class PointAdjuster extends StageGameObject{

    protected int _amountToAdjust;

    public BufferedImage image;

    public GamePanel gp;

    public PointAdjuster(GamePanel gp, int _amountToAdjust, int x, int y){
        this.gp = gp;// for changing points
        this._amountToAdjust = _amountToAdjust;
        this.x = x;
        this.y = y;
    }

    public int adjustPoints(){
        return _amountToAdjust;
    }

    public void reactCollision(MovableCharacter mc){
        gp.points += adjustPoints();
    }

    public void repaint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(image, x,y,gp.tileSize,gp.tileSize,null);
    }

}
