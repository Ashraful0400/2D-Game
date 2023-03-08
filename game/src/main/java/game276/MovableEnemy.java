package game276;

import java.lang.Math;

import javafx.scene.effect.Light.Distant;

public class MovableEnemy extends MovableCharacter {

    Player player;

    MovableEnemy(GamePanel gp, int startingX, int startingY) {
        super(gp, startingX, startingY);
        this.speed = 5;

        player = gp.player;
    }

    public void move() {
        // Calculate 4 distances to the player
        // Move toward minimum direction

        // TODO - Not done yet
        double upDist = getDistanceFromPlayer(x, y-speed);
        double leftDist = getDistanceFromPlayer(x-speed, y);
        double downDist = getDistanceFromPlayer(x, y+speed);
        double rightDist = getDistanceFromPlayer(x+speed, y);

    }

    private double getDistanceFromPlayer(int newX, int newY) {
        int xDist = Math.abs(player.x - newX);
        int yDist = Math.abs(player.y - newY);

        return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    public void moveBack() {
        super.moveBack();
        // TODO - need to find a way to move MovableEnemy again to another direction
    }
    
}
