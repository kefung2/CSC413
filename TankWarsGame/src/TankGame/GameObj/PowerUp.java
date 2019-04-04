package TankGame.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObj{

    private boolean pickUp = false;

    public  PowerUp (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
    }

    public void draw(Graphics g){
        g.drawImage(this.img, this.x, this.y, this);
    }

    //public void update(){}
}
