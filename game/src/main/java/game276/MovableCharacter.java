package game276;

public abstract class MovableCharacter extends StageGameObject {
    public int speed; // How much character moves each frame; different for each subcalss
    public GamePanel gp;
    // Needed for moveBack()
    public int prevX;
    public int prevY;
    // CollisionHandler


    MovableCharacter(GamePanel gp, int startingX, int startingY) {
        this.gp = gp;
        // Default position
        this.x = startingX;
        this.y = startingY;
    }

    public void move() {};

    public void moveBack() {
        x = prevX;
        y = prevY;
    }
}
