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
     *
     * @param gp game panel that need to display time and points
     */
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    /**
     * drawing time and points on the game window
     *
     * @param g2 2d graphics for drawing
     */
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //Change the number to draw in the screen as needed
        //g2.drawString("Points: " + gp.points, 25, 50);
        //titleScreen
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        if (gp.playState == gp.gameState) {

            g2.setColor(new Color(0,0,0,100));
            g2.fillRect(25,10,200,50);

            g2.fillRect(gp.tileSize*11,25,250,50);


            g2.setColor(Color.white);

            //Change the number to draw in the screen as needed
            g2.drawString("Points: " + gp.points, 25, 50);

            //time
            playTime += (double) 1 / 60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65);

            // Draw cheese left
            // TODO - Test
            FontMetrics fm = g2.getFontMetrics(g2.getFont());
            String text = "Cheese Left: " + gp.spawner.ordinaryRewardNum;
            int width = fm.stringWidth(text);

            g2.setColor(new Color(0,0,0,100));
            g2.fillRect((gp.scrnWidth - width) / 4 * 3,25,300,50);

            g2.setColor(Color.white);
            g2.drawString(text, (gp.scrnWidth - width) / 4 * 3, 50);
        }

        if(gp.gameState == gp.gameOverState){
            announceGameOver(g2);
        }

        // Time
        //playTime += (double) 1 / 60;
        //g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65);


        // Draw cheese left
        // TODO - Test
        //FontMetrics fm = g2.getFontMetrics(g2.getFont());
        //String text = "Cheese Left: " + gp.spawner.ordinaryRewardNum;
        //int width = fm.stringWidth(text);
        //g2.drawString(text, (gp.scrnWidth - width) / 4 * 3, 50);
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

    /**
     * displays end game message on the screen
     * when game is over
     * @param g2D for display graphics on the screen
     */
    public void announceGameOver(Graphics2D g2D){
        String text = "";
        int x;
        int y;
        int width;
        FontMetrics fm;

        //Graphics2D g2D = (Graphics2D) g;

        if(gp.gameState == gp.gameOverState) {
            text = "Game Over";
            g2D.setColor(Color.red);
            if(gp.didWinGame){
                text = "Congratulation";
                g2D.setColor(Color.yellow);
            }
        }
        g2D.setFont(new Font("Courier",Font.BOLD,100));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (gp.scrnWidth - width)/2;
        y = gp.scrnHeight/5;
        g2D.drawString(text,x,y);

        text = "Point: "+gp.points;
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,75));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (gp.scrnWidth - width)/2;
        y += 125;
        g2D.drawString(text,x,y);

        text = "Time: "+gp.ui.dFormat.format(gp.ui.playTime);
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,75));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (gp.scrnWidth - width)/2;
        y += 75;
        g2D.drawString(text,x,y);

        text = "Restart";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,50));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (gp.scrnWidth - width)/2;
        y += 100;
        g2D.drawString(text,x,y);
        if(commandNum == 0){
            g2D.drawString("*",x-30,y);
        }

        text = "Quit";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,50));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (gp.scrnWidth - width)/2;
        y += 50;
        g2D.drawString(text,x,y);
        if(commandNum == 1){
            g2D.drawString("*",x-30,y);
        }

    }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.scrnWidth/2 - length/2;
        return x;
    }
}
