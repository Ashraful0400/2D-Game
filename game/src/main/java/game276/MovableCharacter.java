package game276;

public abstract class MovableCharacter extends StageGameObject {
    public int speed; // How much character moves each frame

    // Needed for moveBack()
    public int prevX;
    public int prevY;
    // CollisionHandler

    public void move() {};

    public void moveBack() {
        x = prevX;
        y = prevY;
    }
}
