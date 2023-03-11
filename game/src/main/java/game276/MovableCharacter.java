package game276;

import java.awt.*;

public abstract class MovableCharacter extends StageGameObject {
    public int speed; // How much character moves each frame
    GamePanel gp;
    public String name;
    public String direction;
    // Needed for moveBack()
    public int prevX;
    public int prevY;
    // CollisionHandler
    //need to add this below line after implementing at video 8 at 18.21 min
    //pickUpObject(objIndex);

    //check tile collision
    public boolean CollisionOn = false;
    //check object collision
   //int objIndex = gp.cChecker.checkObject(this, true);

    public MovableCharacter(GamePanel gp) {
        this.gp = gp;
    }

    public MovableCharacter(GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        this.x = startingX;
        this.y = startingY;
    }


    public void move() {};

    public void moveBack() {
        x = prevX;
        y = prevY;
    }
}
