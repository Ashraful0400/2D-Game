package game276;

public class Spawner {

    private GamePanel gp;

    Spawner(GamePanel gp) {
        this.gp = gp;
    }

    // Generate all entities EXCEPT player
    public void generateAllEntitiesExceptPlayer() {
        generateExitDoor(); // gp's allObjectLst[0] == always exitDoor
        generateMovableEnemies();
    }

    public void generateExitDoor() {
        gp.allObjectLst.add(new ExitCell());
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
