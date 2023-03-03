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
    InputHandler keyI = player.keyboardInput; //Only for adding KeyListener

    int fps = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(keyI);
        this.setFocusable(true);
    }

    public void startThread() {
        gThread = new Thread(this);
        gThread.start();
    }

    public void run() {
        //this.startThread();
        Double drawInterval = 1000000000.0 / fps;
        Double nextDrawTime = System.nanoTime() + drawInterval; // Calculate what time next frame should get drawn

        while (gThread != null) {
            System.out.println("YOOOOLOOOOOOOOOOOOOOO");

            update();

            Double remainingTime = nextDrawTime - System.nanoTime(); // Remaining time after update()
            remainingTime /= 1000000; // Converting to miliseconds
            try {
                if (remainingTime < 0) {
                    remainingTime = 0.0;
                }
                Thread.sleep(remainingTime.longValue()); // TODO - Random big number for now
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
