package game276;

public class BonusReward extends Reward{
    protected int _amountToAdjust;

    public BonusReward(GamePanel gp, int _amountToAdjust, int x, int y){
        super(gp, _amountToAdjust, x, y);
        this._amountToAdjust = _amountToAdjust;
    }
}
