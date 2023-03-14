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
       // createFloorsAt(00,00);
        createFloorsAt(1375,25);
        for(int i = 00; i < 1525; i++){
            for(int j = 00; j < 970; j++)
            {
                createFloorsAt(i,j);
                j += 48;
            }
            i += 48;
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
        gp.allObjectLst.add(new ExitCell(gp, 1490, 910));
    }

    /**
     * Create barrier, call constructor of Barrier
     */
    private void generateBarriers() {
       // createBarrierAt(-50, 900);
        //creating barrier at top
    for(int i = -50; i <= 1500 ; i++) {
        i += 48;
        createBarrierAt(i, -50);
        }
        //creating barrier at left
        for(int i = -50; i <= 1000 ; i++)
        {
            i += 48;
            createBarrierAt(-50, i);
        }
        //creating barrier at bottom
        for(int i = -50; i <= 1500 ; i++)
        {
            i += 48;
            createBarrierAt(i, 975);
        }
        //creating barrier at right
        for(int i = -50; i <= 1000; i++)
        {
            i += 48;
            createBarrierAt(1535, i);
        }


        //Now inside the map
        for(int i = 225; i < 550; i++){
            i += 48;
            createBarrierAt(i, 50);
        }
        for(int i = 750; i < 1250; i++){
            i += 48;
            createBarrierAt(i, 50);
        }
        for(int i = 0; i < 200; i++){
            i += 48;
            createBarrierAt(40, i);
        }

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
        createRewardAt(700, 20);
        createRewardAt(775, 20);
        createRewardAt(20, 250);
        createRewardAt(120, 250);
        createRewardAt(500, 800);
        createRewardAt(1000, 110);
        createRewardAt(900, 350);
        createRewardAt(270, 850);
        createRewardAt(1100, 600);

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
        createRewardBonusAt(180, 20);
        createRewardBonusAt(375, 66);
        createRewardBonusAt(900, 20);
        createRewardBonusAt(850, 300);
        createRewardBonusAt(1001, 850);
        createRewardBonusAt(900, 442);
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
        createMovableEnemyAt(1000, 600);
        createMovableEnemyAt(500, 350);

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
