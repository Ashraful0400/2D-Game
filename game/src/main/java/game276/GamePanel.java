package game276;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
//import barrier.*;

import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    // TODO - check negative points
//screen settings
    int scale = 3;
    int ogTileSize = 16;//16x16 tile

    public int tileSize = ogTileSize * scale;// 48 x 48 tile
    public int maxScrnColNum = 16;
    public int maxScrnRowNum = 16;
    public int points;

    int scrnWidth = maxScrnColNum * tileSize; // 768 pixels
    int scrnHeight = maxScrnRowNum * tileSize; //576 pixels

    Thread gThread;


    public Player player = new Player(this, 100, 100);
    public Spawner spawner = new Spawner(this);

    public ArrayList<StageGameObject> allObjectLst = new ArrayList<StageGameObject>();
    public ArrayList<MovableEnemy> movEnemyLst = new ArrayList<MovableEnemy>();
    public ArrayList<PointAdjuster> pointAdjusterLst = new ArrayList<PointAdjuster>();




    int fps = 60;
    public CollisionHandler cHandler = new CollisionHandler(this);
    public boolean isGameOver;
    //Calling Barrier Manager
    // BarrierManager tileM = new BarrierManager(this);
    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(player.keyboardInput);
        this.setFocusable(true);
        points = 0;

    }
    public void setUpGame(){
        spawner.generateAllEntitiesExceptPlayer(); // gp's allObjectLst[0] == always exitDoor
    }

    public void startThread() {
        isGameOver = false;
        gThread = new Thread(this);
        gThread.start();
    }



    public void run() {
        Double drawInterval = 1000000000.0 / fps;
        Double nextDrawTime = System.nanoTime() + drawInterval; // Calculate what time next frame should get drawn

        while (gThread != null && !isGameOver) {
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
        cHandler.processObjectCollision(player);
    }

    public void announceGameOver(Graphics g){
        String text = "Game over";
        int x = this.scrnWidth/2;
        int y = this.scrnHeight/2;

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,100));
        g2D.drawString(text,x,y);

    }



    public void paintComponent(Graphics g) {
        /* super.paintComponent(g);
        //draws tiles
        //TODO - might be a prob
        // tileM.draw((Graphics2D) g);
        for(int i = 0; i < pointAdjusterLst.size(); i++){
            pointAdjusterLst.get(i).repaint(g);
        }

        //draws object
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] != null ){
                obj[i].draw((Graphics2D)g ,this);
            }
        }
        //draws player
        player.repaint(g);
        for (int i = 0; i < movEnemyLst.size(); i++) {
            movEnemyLst.get(i).repaint(g);
        }
      

        g.dispose();// Free resources related to g2D
 */

        super.paintComponent(g);
        player.repaint(g);
        for (int i = 0; i < allObjectLst.size(); i++) {
            allObjectLst.get(i).repaint(g);
        }

        if (isGameOver) {
            announceGameOver(g);
        }
        
        g.dispose();// Free resources related to g2D
    }

}
  