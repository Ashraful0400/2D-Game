package Object;

import game276.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class  SuperObject {
    public static BufferedImage image;
    public static String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultY = 0;
    public int solidAreaDefaultX = 0;
    public void draw(Graphics2D g2, GamePanel gp){
         g2.drawImage(image,worldX,worldY,gp.tileSize,gp.tileSize,null);
    }
}
