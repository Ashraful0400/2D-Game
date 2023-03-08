package game276;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.ArrayList;


public class GamePanel extends JPanel implements Runnable {

    int scale = 3;
    int ogTileSize = 16;

    int tileSize = ogTileSize * scale;
    int maxScrnColNum = 16;
    int maxScrnRowNum = 16;

    int scrnWidth = maxScrnColNum * tileSize;
    int scrnHeight = maxScrnRowNum * tileSize;

    Thread gThread;

    int fps = 60;


    Player player = new Player(this, 100, 100);
    ArrayList<MovableEnemy> movEnemyLst = new ArrayList<MovableEnemy>();

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
        generateMovableEnemies();
    }

    private void generateMovableEnemies() {
        createMovableEnemyAt(100, 200);
    }

    private void createMovableEnemyAt(int x, int y) {
        movEnemyLst.add(new MovableEnemy(this, x, y));
    }

    public void run() {
        Double drawInterval = 1000000000.0 / fps;
        Double nextDrawTime = System.nanoTime() + drawInterval; // Calculate what time next frame should get drawn

        while (gThread != null) {

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
        for (int i = 0; i < movEnemyLst.size(); i++) {
            movEnemyLst.get(i).move();
        }
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        player.repaint(g);
        for (int i = 0; i < movEnemyLst.size(); i++) {
            movEnemyLst.get(i).repaint(g);
        }


      /*   System.out.println("painting enemy");
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.red);
        g2D.fillRect(movEnemyLst.get(0).x, movEnemyLst.get(0).y, this.tileSize, this.tileSize);
        g2D.dispose(); // Free resources related to g2D
 */

        g.dispose(); // Free resources related to g2D

    }

}
