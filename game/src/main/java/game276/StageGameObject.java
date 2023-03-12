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
    public String imagePath;
    public GamePanel gp;
    public BufferedImage sprite;

    public boolean collision = false;
    public Rectangle hitBox;
    public int hitboxLength;





    public void getImage() {        // TODO - delete one of the Images directories
        try {
            // load image for imagePath
            System.out.println(imagePath);
            if (new File(imagePath).exists()) {
                System.out.println("It's not null");
            } else {
                System.out.println("Doesn't exist");
            }
            //sprite = ImageIO.read(new File(this.imagePath));
            sprite = ImageIO.read(this.getClass().getResource(imagePath));
            


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void repaint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        
        // TODO -implement drawing
        g2D.drawImage(sprite, x,y,gp.tileSize,gp.tileSize,null);
        //g2D.setColor(Color.white);
        //g2D.fillRect(x, y, hitboxLength, hitboxLength);
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
