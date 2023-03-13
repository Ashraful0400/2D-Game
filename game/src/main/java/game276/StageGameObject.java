package game276;

import java.io.File;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;

/**
 * represents objects that will be on the game window
 */
public abstract class StageGameObject {
    /**
     * setting
     */
    public int x;
    public int y; //y increase -> move downward
    public String imagePath;
    public GamePanel gp;
    public BufferedImage sprite;

    public boolean collision = false;
    public Rectangle hitBox;
    public int hitboxLength;


    /**
     * get image of the objects
     */
    public void getImage() {
        try {
            //sprite = ImageIO.read(new File(this.imagePath)); // works only on some computers
            sprite = ImageIO.read(this.getClass().getResource(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * drawing the objects
     * @param g graphic for drawing the objects
     */
    public void repaint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        
        // TODO -implement drawing
        g2D.drawImage(sprite, x,y,gp.tileSize,gp.tileSize,null);
        //g2D.setColor(Color.white);
        //g2D.fillRect(x, y, hitboxLength, hitboxLength);
    }

    /**
     * things to do when collide with character
     * @param mc character that is collided
     */
    public void reactToCollision(MovableCharacter mc) {};

    /* public static BufferedImage image;
    public static String name;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultY = 0;
    public int solidAreaDefaultX = 0;
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image,worldX,worldY,gp.tileSize,gp.tileSize,null);
    } */
}
