package game276;

public class Reward extends PointAdjuster{

    protected int _amountToAdjust;

    public Reward(GamePanel gp, int _amountToAdjust, int x, int y){
        super(gp, _amountToAdjust, x, y);
        this._amountToAdjust = _amountToAdjust;
    }
}
