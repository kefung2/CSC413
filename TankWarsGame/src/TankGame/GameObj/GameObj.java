package TankGame.GameObj;

import java.awt.image.BufferedImage;

public abstract class GameObj {

    private BufferedImage img;
    private int speed;

    public GameObj(){}

    public GameObj (BufferedImage img, int speed){
        this.img = img;
        this.speed = speed;
    }

}
