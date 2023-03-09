package tile;

import game276.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
   public Tile [] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        //makes the tile
       mapTileNum = new int[gp.maxScrnColNum][gp.maxScrnRowNum];
        getTileImage();
        loadMap("/maps/map01.txt" );
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
//making the collision true because it won't let player togo through a barricade
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;
//making the collision true because it won't let player togo through a barricade
            tile[2] = new Tile();
            //ImageIo is gonna read the picture and gonna show the picture in the game
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/furniture.png"));
            tile[2].collision = true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int column = 0; int row = 0;
            while(column < gp.maxScrnColNum && row < gp.maxScrnRowNum ){
                String line = br.readLine();
                while(column < gp.maxScrnColNum){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[column]);
                    mapTileNum[column][row]  = num;
                    column++;
                }
                if(column == gp.maxScrnColNum){
                    column = 0;
                    row++;
                }
            }
        br.close();
        }catch (Exception e){

        }
    }
    public void draw(Graphics2D g2){
       int column = 0;
       int row = 0;
       int x = 0;
       int y = 0;
       //this while loop is gonna draw every cell with animation we are gonna draw
       while(column < gp.maxScrnColNum && row < gp.maxScrnRowNum){
           int tileNum = mapTileNum[column][row];
           g2.drawImage(tile[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
           column ++;
           x += gp.tileSize;
           if(column == gp.maxScrnColNum){
               column = 0;
               x = 0;
               row++;
               y += gp.tileSize;
           }

       }
    }
}
