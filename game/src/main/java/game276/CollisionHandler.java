package game276;

public class CollisionHandler {
    GamePanel gp;
    public CollisionHandler(GamePanel gp){
      this.gp = gp;
    }

    public void processObjectCollision (MovableCharacter mc) {
        for (int i = 0; i < gp.allObjectLst.size(); i++) {
            StageGameObject curObj = gp.allObjectLst.get(i);

            if (mc != curObj && mc.hitBox.intersects(curObj.hitBox)) {
                System.out.println("COLLISION");
                curObj.reactToCollision(mc);
            }

        }
    }


/* 
    public boolean processObjectCollision (MovableCharacter movableCharacter){
    int movableCharacterLeftWorldX = movableCharacter.prevX + movableCharacter.hitBox.x;
    int movableCharacterRightWorldX = movableCharacter.prevX + movableCharacter.hitBox.x + movableCharacter.hitBox.width;
    int movableCharacterTopWorldY = movableCharacter.prevY+ movableCharacter.hitBox.y;
    int movableCharacterBottomWorldY = movableCharacter.prevY + movableCharacter.hitBox.y + movableCharacter.hitBox.height;

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
    } */
    //
    /* 
    public int checkObject(MovableCharacter move,boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                //get character's solid area position
                move.hitBox.x = move.prevX + move.hitBox.x;
                move.hitBox.y = move.prevY + move.hitBox.y;
                //get the object 's solid area position
                gp.obj[i].hitBox.x = gp.obj[i].worldX + gp.obj[i].hitBox.x;
                gp.obj[i].hitBox.y = gp.obj[i].worldY + gp.obj[i].hitBox.y;

                switch (move.direction) {
                    case "up":
                        move.hitBox.y -= move.speed;
                        if (move.hitBox.intersects(gp.obj[i].hitBox)) {
                        if(gp.obj[i].collision == true){
                            move.CollisionOn = true;
                        }
                        if(player == true){
                            index = i  ;
                        }
                        }
                        break;

                    case "down":
                        move.hitBox.y += move.speed;
                        if (move.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision == true){
                                move.CollisionOn = true;
                            }
                            if(player == true){
                                index = i  ;
                            }
                        }
                        break;

                    case "left":
                        move.hitBox.x -= move.speed;
                        if (move.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision == true){
                                move.CollisionOn = true;
                            }
                            if(player == true){
                                index = i  ;
                            }
                        }
                        break;

                    case "right":
                        move.hitBox.x += move.speed;
                        if (move.hitBox.intersects(gp.obj[i].hitBox)) {
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

            move.hitBox.x = move.solidAreaDefaultX;
            move.hitBox.y = move.solidAreaDefaultY;
            gp.obj[i].hitBox.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].hitBox.y = gp.obj[i].solidAreaDefaultY;

        }
        return index;
    } */
}
