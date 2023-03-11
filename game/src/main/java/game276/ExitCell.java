package game276;


import game276.GamePanel;
import game276.MovableCharacter;
import game276.StageGameObject;
import game276.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ExitCell extends StageGameObject {
    public ExitCell() {

        try {
            //possible error
            sprite = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }


}

