package game276;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class MovableEnemy extends MovableCharacter {

    Player player;
    ArrayList<Double> distLst;
    Double upDist;
    Double leftDist;
    Double downDist;
    Double rightDist;
    

    MovableEnemy(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        this.speed = 2;
        player = gp.player;

        imagePath = "cat/New Piskel-1.png (1).png";
        getImage();

    }

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
            y -= speed;
        } else if (minDist == leftDist) {
            x -= speed;
        } else if (minDist == downDist) {
            y += speed;
        } else if (minDist == rightDist) {
            x += speed;
        } 

        System.out.println(" " + x + " " + y);
        resetHitboxPos();

    }

    private double getDistanceFromPlayer(int newX, int newY) {
        int xDist = Math.abs(player.x - newX);
        int yDist = Math.abs(player.y - newY);

        return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    public void moveBack() {
        super.moveBack();
        moveAgain();
        // TODO - need to find a way to move MovableEnemy again to another direction
    }

    // TODO - Gets stuck still even if not a corner
    public void moveAgain() { // Assumes distLst && all direction fields is set
        Double secondMinDist = distLst.get(1);
        if (secondMinDist == upDist) {
            y -= speed;
        } else if (secondMinDist == leftDist) {
            x -= speed;
        } else if (secondMinDist == downDist) {
            y += speed;
        } else if (secondMinDist == rightDist) {
            x += speed;
        } 
    }


    // Just draws a rectangle for now
    public void repaint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.red);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

    public void reactToCollision(MovableCharacter mc) {
        gp.isGameOver = true;
    }
    
}
