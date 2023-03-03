package game276;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {

    int scale = 3;
    int ogTileSize = 16;

    int tileSize = ogTileSize * scale;
    int maxScrnColNum = 16;
    int maxScrnRowNum = 16;

    int scrnWidth = maxScrnColNum * tileSize;
    int scrnHeight = maxScrnRowNum * tileSize;

    Thread gThread;

    Player player = new Player(this);
    InputHandler keyH = player.input;

    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startThread() {
        gThread = new Thread(this);
        gThread.start();
    }

    public void run() {
        //this.startThread();
        while (gThread != null) {
            System.out.println("YOOOOLOOOOOOOOOOOOOOO");
            update();

            repaint();

            try {
                Thread.sleep((long) 1000); // TODO - Random big number for now
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.move();
    }

    public void repaint() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.fillRect(100, 100, tileSize, tileSize);
        g2D.dispose(); // Free resources related to g2D */

        player.repaint(g);

    }

}
