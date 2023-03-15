package game276;


import game276.GamePanel;
import game276.MovableCharacter;
import game276.StageGameObject;

import javax.imageio.ImageIO;
import java.io.IOException;

import java.awt.*;

/**
 * this class represents an object that
 * allows player to wins when it is touched with
 * player and all regular rewards are collected
 */
public class ExitCell extends StageGameObject {
    /**
     * Construct
     * @param gp game panel that the exit will be placed
     * @param x x coordinate for exit on the game
     * @param y y coordinate for exit on the game
     */
    public ExitCell(GamePanel gp, int x, int y) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        hitboxLength = 20;
        hitBox = new Rectangle(x,y, hitboxLength, hitboxLength);
        imagePath = "Images/door/doorClose.png";
        getImage();
    }

    /**
     * this method checks winning condition of Movable Character
     * and end the game if all conditions meet
     * @param mc character that collide with this object
     */
    public void reactToCollision(MovableCharacter mc) {
        // TODO - change the point checker as much as cheese you will make to end the game after collecting all the cheese
        // TODO - Need to change gameOver condition (bonusRewards also count)

        // TODO - Need to change so it WINS the game
        if (mc == gp.player && gp.spawner.ordinaryRewardNum == 0) {
            imagePath = "Images/door/doorOpen.png";
            getImage();
            gp.didWinGame = true;
            gp.gameState = gp.gameOverState;
        }
    }
}

