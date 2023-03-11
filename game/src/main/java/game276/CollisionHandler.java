package game276;

public class CollisionHandler {
    GamePanel gp;
    public CollisionHandler(GamePanel gp){
      this.gp = gp;
    }
    public boolean processObjectCollision (MovableCharacter movableCharacter){
    int movableCharacterLeftWorldX = movableCharacter.prevX + movableCharacter.solidArea.x;
    int movableCharacterRightWorldX = movableCharacter.prevX + movableCharacter.solidArea.x + movableCharacter.solidArea.width;
    int movableCharacterTopWorldY = movableCharacter.prevY+ movableCharacter.solidArea.y;
    int movableCharacterBottomWorldY = movableCharacter.prevY + movableCharacter.solidArea.y + movableCharacter.solidArea.height;

    int movableCharacterBottomRow = movableCharacterBottomWorldY/gp.tileSize;
    int movableCharacterLeftColumn =movableCharacterLeftWorldX / gp.tileSize;
    int movableCharacterRightColumn = movableCharacterRightWorldX / gp.tileSize;
    int movableCharacterTopRow = movableCharacterTopWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (movableCharacter.direction){
            case "up":
        movableCharacterTopRow = (movableCharacterTopWorldY - movableCharacter.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[movableCharacterLeftColumn][movableCharacterTopRow];
            tileNum2 = gp.tileM.mapTileNum[movableCharacterRightColumn][movableCharacterTopRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                movableCharacter.CollisionOn = true;
                return true;
            }
            break;

            case "down":
                movableCharacterBottomRow = (movableCharacterBottomWorldY + movableCharacter.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[movableCharacterLeftColumn][movableCharacterBottomRow];
                tileNum2 = gp.tileM.mapTileNum[movableCharacterRightColumn][movableCharacterBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    movableCharacter.CollisionOn = true;
                    return true;
                }
                break;

            case "left":
                movableCharacterLeftColumn = (movableCharacterLeftWorldX - movableCharacter.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[movableCharacterLeftColumn][movableCharacterTopRow];
                tileNum2 = gp.tileM.mapTileNum[movableCharacterRightColumn][movableCharacterBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    movableCharacter.CollisionOn = true;
                    return true;
                }
                break;

            case "right":
                movableCharacterRightColumn = (movableCharacterRightWorldX +  movableCharacter.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[movableCharacterRightColumn][movableCharacterTopRow];
                tileNum2 = gp.tileM.mapTileNum[movableCharacterRightColumn][movableCharacterTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    movableCharacter.CollisionOn = true;
                    return true;
                }
                break;

        }
        return false;
    }
    //
public int checkObject(MovableCharacter move,boolean player) {
    int index = 999;

    for (int i = 0; i < gp.obj.length; i++) {
        if (gp.obj[i] != null) {
            //get character's solid area position
            move.solidArea.x = move.prevX + move.solidArea.x;
            move.solidArea.y = move.prevY + move.solidArea.y;
            //get the object 's solid area position
            gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
            gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

            switch (move.direction) {
                case "up":
                    move.solidArea.y -= move.speed;
                    if (move.solidArea.intersects(gp.obj[i].solidArea)) {
                       if(gp.obj[i].collision == true){
                           move.CollisionOn = true;
                       }
                       if(player == true){
                           index = i  ;
                       }
                    }
                    break;

                case "down":
                    move.solidArea.y += move.speed;
                    if (move.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collision == true){
                            move.CollisionOn = true;
                        }
                        if(player == true){
                            index = i  ;
                        }
                    }
                    break;

                case "left":
                    move.solidArea.x -= move.speed;
                    if (move.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collision == true){
                            move.CollisionOn = true;
                        }
                        if(player == true){
                            index = i  ;
                        }
                    }
                    break;

                case "right":
                    move.solidArea.x += move.speed;
                    if (move.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collision == true){
                            move.CollisionOn = true;
                        }
                        if(player == true){
                            index = i  ;
                        }
                    }
                    break;

            }
        }

        move.solidArea.x = move.solidAreaDefaultX;
        move.solidArea.y = move.solidAreaDefaultY;
        gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
        gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

    }
    return index;
}
}
