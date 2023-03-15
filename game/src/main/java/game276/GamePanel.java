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

    int scrnWidth = maxScrnColNum * tileSize; // 1536 pixels
    int scrnHeight = maxScrnRowNum * tileSize; // 960 pixels

    int fps = 60;
    Thread gThread;

    public int points;

    public int endGameOP = 0;
    public boolean isGameOver; // gets toggled true no matter player loses or wins
    public boolean didWinGame; 

    public Player player = new Player(this, 100, 100);
    public Spawner spawner = new Spawner(this);
    public CollisionHandler cHandler = new CollisionHandler(this);

    public ArrayList<StageGameObject> allObjectLst = new ArrayList<StageGameObject>();
    public ArrayList<MovableEnemy> movEnemyLst = new ArrayList<MovableEnemy>();
    public ArrayList<PointAdjuster> pointAdjusterLst = new ArrayList<PointAdjuster>();
    public ArrayList<Barrier> barriersLst = new ArrayList<Barrier>();

    //for the menu
    public int gameState ;
    public final int titleState = 0;
    public int playState = 1;

    public UI ui = new UI(this);

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
        spawner.generateAllEntitiesExceptPlayer();
        gameState = titleState;
    }

    /**
     * this method crates thread that runs the game
     */
    public void startThread() {
        isGameOver = false;
        didWinGame = false;
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

        while (gThread != null) {
            System.out.println("YOOOOLOOOOOOOOOOOOOOO");
            if(!isGameOver) {
                update();
            }

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

            // Menu for game ending
            if (isGameOver) { 
                displayEndGameMenu();
            }

            repaint();

        }
    }

    /**
     * Shows the menu to either retry or quit the game;
     * Must be called inside run()'s while loop
     * to receive player input
     */
    public void displayEndGameMenu() {
        if (player.keyboardInput.upKeyPressed) {
            endGameOP = 0;
        } else if (player.keyboardInput.downKeyPressed) {
            endGameOP = 1;
        } else if (player.keyboardInput.EnterPressed) {
            switch (endGameOP) {
                case 0:
                    player.x = 100;
                    player.y = 100;
                    player.imagePath = "Images/mouse/mouseForward.png";
                    player.getImage();
                    points = 0;
                    endGameOP = 0;
                    ui.playTime = 0;
                    while(!movEnemyLst.isEmpty()){
                        movEnemyLst.remove(0);
                    }
                    while(!allObjectLst.isEmpty()){
                        allObjectLst.remove(0);
                    }
                    setUpGame();
                    isGameOver = false;
                    didWinGame = false;
                    break;
                case 1:
                    System.exit(0);
                    break;
            }
        }
        return;
    }

    /**
     * this method update position for each object
     * and call collision handler when it gets called
     */
    public void update() {
        if(gameState == playState){
            player.move();
        }
        // player.move();
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

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        // Title screen/Menu at the beginning
        if (gameState == titleState){
            ui.draw(g2);
        } else {
            for (int i = 0; i < allObjectLst.size(); i++) {
                allObjectLst.get(i).repaint(g); 
            }

            if(!isGameOver) {
                ui.draw(g2);
            }
            player.repaint(g);


            if (isGameOver) {
                announceGameOver(g);
            }
        }

        g.dispose();// Free resources related to g2D

    }

    /**
     * displays end game message on the screen
     * when game is over
     * @param g for display graphics on the screen
     */
    public void announceGameOver(Graphics g){
        String text = "";
        int x;
        int y;
        int width;
        FontMetrics fm;

        Graphics2D g2D = (Graphics2D) g;

        if(isGameOver) {
            text = "Game Over";
            g2D.setColor(Color.red);
            if(didWinGame){
                text = "Congratulation";
                g2D.setColor(Color.yellow);
            }
        }
        g2D.setFont(new Font("Courier",Font.BOLD,100));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y = this.scrnHeight/5;
        g2D.drawString(text,x,y);

        text = "Point: "+points;
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
        if(endGameOP == 0){
            g2D.drawString("*",x-30,y);
        }

        text = "Quit";
        g2D.setColor(Color.white);
        g2D.setFont(new Font("Courier",Font.BOLD,50));
        fm = g2D.getFontMetrics(g2D.getFont());

        width = fm.stringWidth(text);
        x = (this.scrnWidth - width)/2;
        y += 50;
        g2D.drawString(text,x,y);
        if(endGameOP == 1){
            g2D.drawString("*",x-30,y);
        }

    }


}
  