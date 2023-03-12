package game276;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Font arial_40;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
   // BufferedImage cheeseImage;//if we use cheese image on screen
    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 =  new Font("Arial",Font.PLAIN,40);

    }

public void draw(Graphics2D g2){
    g2.setFont(arial_40);
    g2.setColor(Color.white);
    //Change the number to draw in the screen as needed
    g2.drawString("cheese = " + gp.points,25,50);

    //Time
    playTime += (double)1/60;
    g2.drawString("Time:" + dFormat.format(playTime),gp.tileSize*11, 65);
    }
}
