package TankGame.GameObj;

import TankGame.GameObj.Tank;
import TankGame.TankWorld;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class UnBreakableWall extends GameObj{
    Rectangle wall;
    private int width, height;

    //public UnBreakableWall(){}

    public  UnBreakableWall (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
        this.width = img.getWidth();
        this.height = img.getHeight();
        wall = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){
        g.drawImage(this.img, this.x, this.y, this);
    }

}
