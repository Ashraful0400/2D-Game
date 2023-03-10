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
    // void reactToCollision()
    public int hitboxLength;
    /* public void repaint(Graphics g) {
        // Draw the image
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage();
    }; */

    public void repaint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, x,y,gp.tileSize,gp.tileSize,null);
    }
}
