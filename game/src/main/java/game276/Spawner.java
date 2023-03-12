package game276;

public class Spawner {

    private GamePanel gp;

    Spawner(GamePanel gp) {
        this.gp = gp;
    }

    // Generate all entities EXCEPT player
    public void generateAllEntitiesExceptPlayer() {
        //generateExitDoor(); // gp's allObjectLst[0] == always exitDoor
        generateMovableEnemies();
        generateRewards();
        generateBarriers();
    }

    private void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell(gp, 1000, 1000));
    }

    private void generateBarriers() {
        createBarrierAt(150, 150);
    }
    private void createBarrierAt(int x, int y) {
        Barrier newM = new Barrier(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.barriersLst.add(newM);
    }

    private void generateRewards() {
        createRewardAt(400, 400);
    } 
    private void createRewardAt(int x, int y) {
        gp.allObjectLst.add(new Reward(gp, x, y));
    }  


    private void generateMovableEnemies() {
        createMovableEnemyAt(100, 400);
    }
    private void createMovableEnemyAt(int x, int y) {
        MovableEnemy newM = new MovableEnemy(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.movEnemyLst.add(newM);
    }
}
