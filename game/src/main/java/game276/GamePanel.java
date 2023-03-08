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

    Player player = new Player(this, 100, 100);

    int fps = 60;

    boolean isGameOver;

    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(player.keyboardInput);
        this.setFocusable(true);
    }

    public void startThread() {
        isGameOver = false;
        gThread = new Thread(this);
        gThread.start();
    }

    public void run() {
        Double drawInterval = 1000000000.0 / fps;
        Double nextDrawTime = System.nanoTime() + drawInterval; // Calculate what time next frame should get drawn

        while (gThread != null) {
            System.out.println("YOOOOLOOOOOOOOOOOOOOO");

            update();

            // Wait for redrawing (for 60 FPS)
            Double remainingTime = nextDrawTime - System.nanoTime(); // Remaining time after update()
            remainingTime /= 1000000; // Converting to miliseconds
            try {
                if (remainingTime < 0) {
                    remainingTime = 0.0;
                }
                Thread.sleep(remainingTime.longValue());
                nextDrawTime += drawInterval;
            } catch (Exception e) {
                e.printStackTrace();
            }

            repaint();

        }
    }

    public void update() {
        player.move();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        player.repaint(g);



    }

}
