package game276;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    int scale = 3;
    int ogTileSize = 16;

    int tileSize = ogTileSize * scale;
    int maxScrnColNum = 16;
    int maxScrnRowNum = 16;

    int scrnWidth = maxScrnColNum * tileSize;
    int scrnHeight = maxScrnRowNum * tileSize;

    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
    }

    public void run() {
        
    }

}
