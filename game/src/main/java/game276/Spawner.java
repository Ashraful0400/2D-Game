package game276;

public class Spawner {

    private GamePanel gp;

    Spawner(GamePanel gp) {
        this.gp = gp;
    }

    // Generate all entities EXCEPT player
    public void generateAllEntitiesExceptPlayer() {
        //generateExitDoor(); // gp's allObjectLst[0] == always exitDoor
        //generateMovableEnemies();
        generateBarriers();
    }

    public void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell(gp, 1000, 1000));
    }

    public void generateBarriers() {
        createBarrierAt(150, 150);
    }

    public void createBarrierAt(int x, int y) {
        Barrier newM = new Barrier(gp, x, y);
        gp.allObjectLst.add(newM);
    }

    public void generateMovableEnemies() {
        createMovableEnemyAt(100, 200);
    }

    public void createMovableEnemyAt(int x, int y) {
        MovableEnemy newM = new MovableEnemy(gp, x, y);
        gp.allObjectLst.add(newM);
        gp.movEnemyLst.add(newM);
    }
}
