package game276;

/**
 * This class handles collision for all objects in the game panel
 */
public class CollisionHandler {
    /**
     * Game panel that collision handler will
     * take care the collision
     */
    GamePanel gp;

    /**
     * Construct
     * @param gp game panel that needs to take care collision
     */
    public CollisionHandler(GamePanel gp){
      this.gp = gp;
    }

    /**
     * This method detects any collision and calls
     * corresponding reactToCollsion method
     * @param mc movable character that may collide with
     *           other object
     */
    public void processObjectCollision (MovableCharacter mc) {
        for (int i = 0; i < gp.allObjectLst.size(); i++) {
            StageGameObject curObj = gp.allObjectLst.get(i);

            if (mc != curObj && mc.hitBox.intersects(curObj.hitBox)) {
                System.out.println("COLLISION");
                curObj.reactToCollision(mc);
            }

        }
    }

}
