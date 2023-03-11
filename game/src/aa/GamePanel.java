package game276;

import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
//screen settings
    int scale = 3;
    int ogTileSize = 16;//16x16 tile

    public int tileSize = ogTileSize * scale;// 48 x 48 tile
   public int maxScrnColNum = 16;
     public int maxScrnRowNum = 16;

    int scrnWidth = maxScrnColNum * tileSize; // 768 pixels
    int scrnHeight = maxScrnRowNum * tileSize; //576 pixels

    Thread gThread;

    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, 100, 100);
    //change the arraay to show as much of object it can fit on the map
    public SuperObject obj[] = new SuperObject[10];
    int fps = 60;
    public CollisionHandler cChecker = new CollisionHandler(this);

    TileManager tileM = new TileManager(this);
    public GamePanel() {
        this.setPreferredSize(new Dimension(scrnWidth, scrnHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Improves game rendering performance
        this.addKeyListener(player.keyboardInput);
        this.setFocusable(true);

    }
    public void setUpGame(){
        aSetter.setObject();
    }

    public void startThread() {
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
//draws tiles
        //might be a prob
    tileM.draw((Graphics2D) g);
    //draws object
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null ){
                obj[i].draw((Graphics2D)g ,this);
            }
        }
    //draws player
        player.repaint(g);

    g.dispose();

    }

}
