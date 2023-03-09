package game276;

public class PointAdjuster extends StageGameObject{

    protected int _amountToAdjust;

    public GamePanel gp;

    public PointAdjuster(GamePanel gp, int _amountToAdjust, int x, int y){
        this.gp = gp;// for changing points
        this._amountToAdjust = _amountToAdjust;
        this.x = x;
        this.y = y;
    }

    public int adjustPoints(){
        return _amountToAdjust;
    }

    public void reactCollision(MovableCharacter mc){
        //TODO decide a place to store points
        adjustPoints();
    }

    private void deletePointAdjuster(){
        //TODO decide how to remove an obj
        // gp.PointAdjuster[i] = null;
    }
}
