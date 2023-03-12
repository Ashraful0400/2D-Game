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
        generateExitDoor();
    }

    public void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell(gp, 725, 725));
    }

    public void generateBarriers() {

            createBarrierAt(150, 150);

    }
    public void createBarrierAt(int x, int y) {
        Barrier newM = new Barrier(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.barriersLst.add(newM);
    }

    public void generateRewards() {
        createRewardAt(400, 400);
    } 
    public void createRewardAt(int x, int y) {
        gp.allObjectLst.add(new Reward(gp, x, y));
    }  


    public void generateMovableEnemies() {
        createMovableEnemyAt(100, 400);
    }
    public void createMovableEnemyAt(int x, int y) {
        MovableEnemy newM = new MovableEnemy(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.movEnemyLst.add(newM);
    }
}
