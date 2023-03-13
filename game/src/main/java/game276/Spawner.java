package game276;

/**
 * this class create all objects
 */
public class Spawner {

    private GamePanel gp;

    /**
     * Constructor
     * @param gp game panel that spawner going to create object
     */
    Spawner(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Create all objects except player
     */
    public void generateAllEntitiesExceptPlayer() {
        // Draw the floor and exitDoor first
        generateFloors();
        generateExitDoor();
        generateMovableEnemies();
        generateRewards();
        generateBarriers();
        generateRewardsBonus();
        
    }
    /**
     * Create barrier, call constructor of Barrier
     */
    private void generateFloors() {
        createFloorsAt(00,00);
        createFloorsAt(1375,25);
        for(int i = 00; i < 1400; i++){
            for(int j = 00; j < 800; j++)
            {
                //change 25 to i to make the floor
                createFloorsAt(i,j);
                j += 40;
            }
            i += 40;
        }
    }



    /**
     * Create barrier at (x,y)
     * @param x position of floor
     * @param y position of floor
     */
    private void createFloorsAt(int x, int y) {
    Floor newM = new Floor(gp, x, y);
        gp.allObjectLst.add(newM);

    }
    /**
     * Create exit, call constructor of ExitCell
     */
    public void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell(gp, 1405, 800));
    }

    /**
     * Create barrier, call constructor of Barrier
     */
    private void generateBarriers() {
       // createBarrierAt(-50, -50);
        //creating barrier at top
    for(int i = -50; i < 1450 ; i++) {
        i += 50;
        createBarrierAt(i, -50);
        }
        //creating barrier at left
        for(int i = -50; i < 750 ; i++)
        {
            i += 50;
            createBarrierAt(-50, i);
        }
        //creating barrier at bottom
        for(int i = -50; i < 1450 ; i++)
        {
            i += 50;
            createBarrierAt(i, 850);
        }
        //creating barrier at right
        for(int i = -50; i < 850; i++)
        {
            i += 50;
            createBarrierAt(1450, i);
        }
        createBarrierAt(1450, 750);
}



    /**
     * Create barrier at (x,y)
     * @param x position of barrier
     * @param y position of barrier
     */
    private void createBarrierAt(int x, int y) {
        Barrier newM = new Barrier(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.barriersLst.add(newM);
    }

    /**
     * Create rewards
     */
    private void generateRewards() {
      //  for(int i = 0; i < 7; i++)
        createRewardAt(400, 400);
        createRewardAt(555, 666);
        createRewardAt(30, 200);
        createRewardAt(700, 123);
        createRewardAt(400, 442);
    }

    /**
     * Create a reward at position (x,y)
     * @param x position of reward
     * @param y position of reward
     */
    private void createRewardAt(int x, int y) {
        gp.allObjectLst.add(new Reward(gp, x, y));
    }

    /**
     * Create  bonus rewards
     */
    public void generateRewardsBonus() {
        //  for(int i = 0; i < 7; i++)
        createRewardBonusAt(40, 400);
        createRewardBonusAt(5, 666);
        createRewardBonusAt(31, 200);
        createRewardBonusAt(01, 123);
        createRewardBonusAt(01, 442);
    }

    /** Create a reward at position (x,y)
     * @param x position of bonus reward
     * @param y position of bonus reward
     */

    private void createRewardBonusAt(int x, int y) {
        gp.allObjectLst.add(new BonusReward(gp, x, y));
    }
    /**
     * Create enemies
     */
    private void generateMovableEnemies() {
        createMovableEnemyAt(100, 400);
        createMovableEnemyAt(500, 600);
        createMovableEnemyAt(100, 750);

    }

    /**
     * Create a Movable Enemy at position (x,y)
     * @param x position of enemy
     * @param y position of enemy
     */
    private void createMovableEnemyAt(int x, int y) {
        MovableEnemy newM = new MovableEnemy(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.movEnemyLst.add(newM);
    }
}
