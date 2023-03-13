package game276;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
//import barrier.*;

import java.util.ArrayList;

/**
 * This class is the main body of 2d game
 *
 */
public class GamePanel extends JPanel implements Runnable {

    /**
     * screen settings
     *
     */
    int scale = 3;
    int ogTileSize = 16;//16x16 tile

    public int tileSize = ogTileSize * scale;// 48 x 48 tile
    public int maxScrnColNum = 32; 
    public int maxScrnRowNum = 20;
    public int points;

    int scrnWidth = maxScrnColNum * tileSize; // 1536 pixels
    int scrnHeight = maxScrnRowNum * tileSize; // 960 pixels

    Thread gThread;


    public Player player = new Player(this, 100, 100);
    public Spawner spawner = new Spawner(this);

    public ArrayList<StageGameObject> allObjectLst = new ArrayList<StageGameObject>();
    public ArrayList<MovableEnemy> movEnemyLst = new ArrayList<MovableEnemy>();
    public ArrayList<PointAdjuster> pointAdjusterLst = new ArrayList<PointAdjuster>();
    public ArrayList<Barrier> barriersLst = new ArrayList<Barrier>();




    int fps = 60;
    public UI ui = new UI(this);
    public CollisionHandler cHandler = new CollisionHandler(this);
    public boolean isGameOver ;
    //Calling Barrier Manager
    // BarrierManager tileM = new BarrierManager(this);

    /**
     * Constructor
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(player.keyboardInput);
        this.setFocusable(true);
        points = 0;

    }

    /**
     * This method is responsible for calling
     * method to create all objects that should
     * be in the game, player is excluded
     */
    public void setUpGame(){
        spawner.generateAllEntitiesExceptPlayer(); // gp's allObjectLst[0] == always exitDoor
    }

    /**
     * this method crates thread that runs the game
     */
    public void startThread() {
        isGameOver = false;
        gThread = new Thread(this);
        gThread.start();
    }


    /**
     * implements run method that from runnable,
     * this method runs until the game stop
     * in each iteration, it is going to call
     * update method to update each tick
     *
     */
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

            if (points < 0) {
                isGameOver = true;
            }


            repaint();

        }
    }

    /**
     * this method update position for each object
     * and call collision handler when it gets called
     */
    public void update() {
        player.move();
        for (int i = 0; i < movEnemyLst.size(); i++) {
            movEnemyLst.get(i).move();
        }
        cHandler.processObjectCollision(player);
        
        for (int i = 0; i < movEnemyLst.size(); i++) {
            cHandler.processObjectCollision(movEnemyLst.get(i));
        }
    }

    /**
     * this method draws each object when it gets called
     *
     * @param g the <code>Graphics</code> object to protect
     */
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

        // TODO - Draw exitCell First
        player.repaint(g);
        for (int i = 0; i < allObjectLst.size(); i++) {
            allObjectLst.get(i).repaint(g);
        }
        Graphics2D g2 = (Graphics2D)g;
        ui.draw(g2);
        
        if (isGameOver) {
            announceGameOver(g);
        }
        
        g.dispose();// Free resources related to g2D
    }

    /**
     * displays end game message on the screen
     * when game is over
     * @param g for display graphics on the screen
     */
    public void announceGameOver(Graphics g){
        String text;
        int x;
        int y;
        int width;
        FontMetrics fm;

        Graphics2D g2D = (Graphics2D) g;

        text = "Game Over";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,100));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y = this.scrnHeight/5;
        g2D.drawString(text,x,y);

        text = "Cheese: "+points;
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,75));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y += 125;
        g2D.drawString(text,x,y);

        text = "Time: "+ui.dFormat.format(ui.playTime);
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,75));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y += 75;
        g2D.drawString(text,x,y);

        text = "Restart";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,50));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y += 100;
        g2D.drawString(text,x,y);

        text = "Quit";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,50));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y += 50;
        g2D.drawString(text,x,y);

    }


}
  