package game276;

import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Object.SuperObject;
import javafx.scene.effect.Light.Point;

import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
//screen settings
    int scale = 3;
    int ogTileSize = 16;//16x16 tile

    public int tileSize = ogTileSize * scale;// 48 x 48 tile
    public int maxScrnColNum = 16;
    public int maxScrnRowNum = 16;
    int points;

    int scrnWidth = maxScrnColNum * tileSize; // 768 pixels
    int scrnHeight = maxScrnRowNum * tileSize; //576 pixels

    Thread gThread;

    public AssetSetter aSetter = new AssetSetter(this);



    public Player player = new Player(this, 100, 100);
    //change the arraay to show as much of object it can fit on the map
    public SuperObject obj[] = new SuperObject[10];
    public ArrayList<MovableEnemy> movEnemyLst = new ArrayList<MovableEnemy>();
    public ArrayList<PointAdjuster> pointAdjuster = new ArrayList<PointAdjuster>();


    int fps = 60;
    public CollisionHandler cChecker = new CollisionHandler(this);
    public boolean isGameOver;

    TileManager tileM = new TileManager(this);
    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(player.keyboardInput);
        this.setFocusable(true);
        points = 0;

    }
    public void setUpGame(){
        aSetter.setObject();
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
        for (int i = 0; i < movEnemyLst.size(); i++) {
            movEnemyLst.get(i).move();
        }
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//draws tiles
        //might be a prob
    tileM.draw((Graphics2D) g);
        for(int i = 0; i < pointAdjuster.size(); i++){
            pointAdjuster.get(i).repaint();
        }

    //draws object
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null ){
                obj[i].draw((Graphics2D)g ,this);
            }
        }
    //draws player
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

    g.dispose();// Free resources related to g2D

    }

}
  