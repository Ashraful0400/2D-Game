package game276;

import java.io.File;

import javax.imageio.ImageIO;
// import javax.imageio.BufferedImage;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javafx.scene.image.Image;

import java.awt.*;

public abstract class StageGameObject {
    public int x;
    public int y; //y increase -> move downward
    public BufferedImage image;
    public GamePanel gp;

    public boolean collision = false;

    public int hitboxLength = 0;

    // hitbox
    public Rectangle hitBox = new Rectangle(0,0, hitboxLength, hitboxLength);


    public void repaint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, x,y,gp.tileSize,gp.tileSize,null);
    }

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
