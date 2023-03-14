package game276;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.*;

/**
 * object for change points
 */
public abstract class PointAdjuster extends StageGameObject{

    /**
     * setting of the adjuster
     */
    protected int _amountToAdjust;

    public BufferedImage image;

    public GamePanel gp;

    /**
     * constructor
     * @param gp game panel that the adjuster will be placed
     * @param x x coordinate for adjuster on the game
     * @param y y coordinate for adjuster on the game
     */
    public PointAdjuster(GamePanel gp, int x, int y){
        this.gp = gp;
        this.x = x;
        this.y = y;
       
        hitboxLength = 13;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);

        this._amountToAdjust = -1;// -1: amount not assign
    }

    /**
     * get how many points should adjuster to change
     * @return amount to change
     */
    public int adjustPoints(){
        return _amountToAdjust;
    }

    /**
     * change point and delete itself
     * when collide with main character
     * @param mc character that collides with adjuster
     */
    public void reactToCollision(MovableCharacter mc) {
        if (mc == gp.player) {
            gp.points += adjustPoints();
            gp.allObjectLst.remove(this);
        }
    }

    /**
     * drawing adjuster on the game window
     * @param g graphic for draing
     */
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(sprite, x,y,gp.tileSize,gp.tileSize,null);
    }
}
