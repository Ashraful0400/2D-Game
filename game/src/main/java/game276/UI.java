package game276;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

/**
 *  Class for displaying time and points
 */
public class UI {
    /**
     * settings
     */
    Graphics2D g2;

    GamePanel gp;
    Font arial_40;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
   // BufferedImage cheeseImage;//if we use cheese image on screen
    public int commandNum = 0;

    /**
     * Constructor
     * @param gp game panel that need to display time and points
     */
    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 =  new Font("Arial",Font.PLAIN,40);
    }

    /**
     * drawing time and points on the game window
     * @param g2 2d graphics for drawing
     */
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //Change the number to draw in the screen as needed
        g2.drawString("Points: " + gp.points,25,50);
        //titleScreen
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        if(gp.playState == gp.gameState){
 
        }

        // Time
        playTime += (double)1/60;
        g2.drawString("Time: " + dFormat.format(playTime),gp.tileSize*11, 65);


        // Draw cheese left
        // TODO - Test
        FontMetrics fm = g2.getFontMetrics(g2.getFont());
        String text = "Cheese Left: " + gp.spawner.ordinaryRewardNum;
        int width = fm.stringWidth(text);
        g2.drawString(text, (gp.scrnWidth - width)/4 * 3, 50);
    }


    public void drawTitleScreen(){
        g2.setColor(new Color(10,10,10));
        g2.fillRect(0,0,gp.scrnWidth,gp.scrnHeight);

        //Title of the game
        g2.setFont(g2.getFont().deriveFont(Font.BOLD));
        String text = "Mouse in the House";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        //MainColor
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize,y);
        }
        g2.drawString(text,x,y);

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize,y);
        }
        g2.drawString(text,x,y);
    }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.scrnWidth/2 - length/2;
        return x;
    }
}
