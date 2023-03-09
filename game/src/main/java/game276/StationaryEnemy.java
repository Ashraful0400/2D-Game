package game276;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StationaryEnemy extends PointAdjuster {

    public StationaryEnemy(GamePanel gp, int _amountToAdjust, int x, int y){
        super(gp, _amountToAdjust, x, y);
        try{
            image = ImageIO.read(getClass().getResourceAsStream(null));//TODO image
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void announceGameOver(Graphics g){
        String text = "Game over";
        int x = gp.scrnWidth/2;
        int y = gp.scrnHeight/2;

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,100));
        g2D.drawString(text,x,y);

    }


}
