package game276;

import java.awt.*;

public abstract class MovableCharacter extends StageGameObject {
    public int speed; // How much character moves each frame
    GamePanel gp;
    public String name;
    // Needed for moveBack()
    public int prevX;
    public int prevY;
    int hasCheese = 0;
    // CollisionHandler
public Rectangle solidArea;
//need to add this below line after implementing at video 8 at 18.21 min
    //pickUpObject(objIndex);
public int solidAreaDefaultX, solidAreaDefaultY;
//check tile collision

public boolean CollisionOn = false;
//check object collision
   int objIndex = gp.cChecker.checkObject(this, true);

    public MovableCharacter(GamePanel gp) {
        super();
    }
public void pickUpObject(int i){
        if(i != 999){

            String objectName = gp.obj[i].name;
            switch(objectName) {
                case "exit":
                    //need to implement game over
            }
        }
}
    public void move() {};

    public void moveBack() {
        x = prevX;
        y = prevY;
    }
}
