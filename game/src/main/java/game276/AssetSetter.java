package game276;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new ExitCell();
        //place the exit door by the setting the coordinate(video 7 at 10 min)
        //  gp.obj[0].worldX = 23*gp.tileSize;
        //gp.obj[0].worldY = 7*gp.tileSize;

    }

}
