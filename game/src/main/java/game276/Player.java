package game276;

import java.awt.*;
import javax.swing.JPanel;

public class Player extends MovableCharacter {
    public GamePanel gp;
    public InputHandler keyboardInput = new InputHandler();


    public Player(GamePanel gp, int startingX, int startingY) {
        super(gp);
        this.gp = gp;
        // Default position
        this.x = startingX;
        this.y = startingY;
        this.speed = 5;
        //chnage as needed in video 8 at 2 min
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        //video 6 (7) min change accordingly
        solidArea = new Rectangle(0,0,gp.tileSize,gp.tileSize);
    }

    public void move() {
        if (keyboardInput.upKeyPressed) {
            direction = "up";
            y -= speed;
        } else if (keyboardInput.leftKeyPressed) {
            direction = "left";
            x -= speed;
        } else if (keyboardInput.downKeyPressed) {
            direction = "down";
            y += speed;
        } else if (keyboardInput.rightKeyPressed) {
            direction = "right";
            x += speed;
        }
        CollisionOn = false;
        gp.cChecker.processObjectCollision(this);

    }

    // Just draws a rectangle for now
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.white);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2D.dispose(); // Free resources related to g2D
    }

}
//whereever you use update neeed to change from video 6 at 10:15 from ashraf (gp.checker) and also update at min 21