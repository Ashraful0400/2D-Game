package game276;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * represents an object that is going to follow the main character
 */
public class MovableEnemy extends MovableCharacter {
    /**
     * settings
     */
    Player player;
    ArrayList<Double> distLst;
    Double upDist;
    Double leftDist;
    Double downDist;
    Double rightDist;

    /**
     * constructor
     * @param gp game panel that the enemy will be placed
     * @param startingX original x coordinate for enemy on the game
     * @param startingY original y coordinate for enemy on the game
     */
    MovableEnemy(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        this.speed = 2;
        player = gp.player;

        imagePath = "Images/cat/catLeft1.png";
        getImage();
    }

    /**
     * moves enemy towards main character
     */
    public void move() {
        prevX = x;
        prevY = y;

        // Calculate 4 distances to the player
        // Move toward minimum direction

        upDist = getDistanceFromPlayer(x, y-speed);
        leftDist = getDistanceFromPlayer(x-speed, y);
        downDist = getDistanceFromPlayer(x, y+speed);
        rightDist = getDistanceFromPlayer(x+speed, y);

        distLst = new ArrayList<Double>();
        distLst.add(upDist);
        distLst.add(leftDist);
        distLst.add(downDist);
        distLst.add(rightDist);
        Collections.sort(distLst);

        Double minDist = distLst.get(0);

        if (minDist == upDist) {
            moveUp();
        } else if (minDist == leftDist) {
            moveLeft();
        } else if (minDist == downDist) {
            moveDown();
        } else if (minDist == rightDist) {
            moveRight();
        } 

        resetHitboxPos();
    }

    /**
     * Calculates distance from player
     * for decides which direction enemy should go
     * @param newX current x of enemy
     * @param newY current y of enemy
     * @return the distance from player
     */
    private double getDistanceFromPlayer(int newX, int newY) {
        int xDist = Math.abs(player.x - newX);
        int yDist = Math.abs(player.y - newY);

        return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    /**
     * move up and change image of the enemy
     */
    private void moveUp() {
        imagePath = "Images/cat/catBack1.png";
        getImage();
        y -= speed;
    }
    /**
     * move left and change image of the enemy
     */
    private void moveLeft() {
        if (imagePath == "Images/cat/catLeft1.png") {
            imagePath = "Images/cat/catLeft1.png";
        } else {
            imagePath = "Images/cat/catLeft1.png";
        }
        getImage();
        x -= speed;
    }
    /**
     * move down and change image of the enemy
     */
    private void moveDown() {
        imagePath = "Images/cat/catRight1.png";
        getImage();
        y += speed;
    }
    /**
     * move right and change image of the enemy
     */
    private void moveRight() {
        if (imagePath == "Images/cat/catRight1.png") {
            imagePath = "Images/cat/catRight2.png";
        } else {
            imagePath = "Images/cat/catRight1.png";
        }
        getImage();
        x += speed;
    }

    /**
     * move back to previous position
     */
    public void moveBack() {
        super.moveBack();
        moveAgain();
    }

    /**
     * move to avoid stuck
     */
    public void moveAgain() { // Assumes distLst && all direction fields is set
        Double secondMinDist = distLst.get(1);
        if (secondMinDist == upDist) {
            moveUp();
        } else if (secondMinDist == leftDist) {
            moveLeft();
        } else if (secondMinDist == downDist) {
            moveDown();
        } else if (secondMinDist == rightDist) {
            moveRight();
        } 
    }


    /**
     * draw enemy on the game window
     * @param g the graphics for drawing
     */
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //g2D.setColor(Color.red);
        //g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2D.drawImage(sprite,x,y,gp.tileSize,gp.tileSize,null);
    }

    /**
     * called when collide with main character
     * @param mc
     */
    public void reactToCollision(MovableCharacter mc) {
        if (mc == player) {
            gp.gameState = gp.gameOverState;
        }
    }
}
