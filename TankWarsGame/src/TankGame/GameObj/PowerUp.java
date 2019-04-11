package TankGame.GameObj;

import TankGame.TankWorld;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObj{

    private boolean pickUp;
    private Tank p1, p2;
    private int width, height;
    private Rectangle PowerUpRect;

    public  PowerUp (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
        this.width = img.getWidth();
        this.height = img.getHeight();
        pickUp = false;
        PowerUpRect = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){
        if(!pickUp) {
            g.drawImage(this.img, this.x, this.y, this);
        }
    }

    public void update() {
        p1 = TankWorld.getTank(1);
        p2 = TankWorld.getTank(2);


        if(p1.collision(PowerUpRect) && !pickUp){
            pickUp = true;
            p1.setFireCD();

        }else if(p2.collision(PowerUpRect) && !pickUp){
            pickUp = true;
            p2.setFireCD();
        }
    }

}
