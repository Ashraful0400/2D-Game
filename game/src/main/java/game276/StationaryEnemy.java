package game276;

import java.awt.*;

public class StationaryEnemy extends PointAdjuster {

    public StationaryEnemy(GamePanel gp, int _amountToAdjust, int x, int y){
        super(gp, _amountToAdjust, x, y);
    }

    public void announceGameOver(Graphics g){
        String text = "Game over";
        int x = gp.scrnWidth/2;
        int y = gp.scrnHeight/2;

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        g2.dispose(); // Free resources related to g2D

    }


}
