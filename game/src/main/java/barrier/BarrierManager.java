package barrier;

import game276.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BarrierManager {
    GamePanel gp;
    public Barrier[] tile;
    public int mapTileNum[][];
    public BarrierManager(GamePanel gp){
        this.gp = gp;
        //how many types of barrier you wanna make
        tile = new Barrier[3];
        //makes the Barrier
        mapTileNum = new int[gp.maxScrnColNum][gp.maxScrnRowNum];
        getBarrierImage();

    }
    public void getBarrierImage(){

        try{
            tile[0] = new Barrier();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
//making the collision true because it won't let player togo through a barricade
            tile[1] = new Barrier();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;
//making the collision true because it won't let player togo through a barricade
            tile[2] = new Barrier();
            //ImageIo is gonna read the picture and gonna show the picture in the game
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/furniture.png"));
            //making the collision true 
            tile[2].collision = true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
