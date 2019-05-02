package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends Boxes{

    int x,y;
    private BufferedImage img;
    private Rectangle WallRect;

/*********************************************************************************************************************/

    public Wall(){}

    public Wall(int x, int y, BufferedImage img){
        //super(x,y,img);
        this.x = x;
        this.y = y;
        this.img = img;
        WallRect = new Rectangle(x,y,img.getWidth(), img.getHeight());
    }

    public void draw(Graphics2D g){
        g.drawImage(img,x+2,y+2, null);
    }

    public Rectangle getWallRect(){
        return WallRect;
    }

}
