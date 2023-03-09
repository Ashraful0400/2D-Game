package Object;


import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Exit extends SuperObject {
    public OBJ_Exit(){
        //possible error
        name = "Exit Door";
        try{
            //possible error
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
