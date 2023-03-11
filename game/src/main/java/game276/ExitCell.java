package game276;


import game276.GamePanel;
import game276.MovableCharacter;
import game276.StageGameObject;
import game276.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ExitCell extends SuperObject {
    public ExitCell() {
        //possible error
        name = "Exit Door";
        try {
            //possible error
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }


}

