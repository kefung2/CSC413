package TankGame.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BreakableWall extends GameObj {
    Rectangle wall;
    private int width, height;
    private boolean dusted = false;

    //public UnBreakableWall(){}

    public  BreakableWall (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
        this.width = img.getWidth();
        this.height = img.getHeight();
        wall = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){
        g.drawImage(this.img, this.x, this.y, this);
    }

    public void dustedWall(){
        dusted = true;
    }

    public void update(){}
}
