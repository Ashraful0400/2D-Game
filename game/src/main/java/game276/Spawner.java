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
        //generateExitDoor(); // gp's allObjectLst[0] == always exitDoor
        generateMovableEnemies();
        generateRewards();
        generateBarriers();
        generateExitDoor();
    }

    /**
     * Create exit, call constructor of ExitCell
     */
    public void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell(gp, 1400, 750));
    }

    /**
     * Create barrier, call constructor of Barrier
     */
    private void generateBarriers() {
        createBarrierAt(150, 150);
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
        createRewardAt(400, 400);
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
     * Create enemies
     */
    private void generateMovableEnemies() {
        createMovableEnemyAt(100, 400);
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
