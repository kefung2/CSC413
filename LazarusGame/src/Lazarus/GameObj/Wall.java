package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends Boxes{

    int x,y;
    private BufferedImage img;
    private LazarusWorld world;
    private Rectangle WallRect;

/*********************************************************************************************************************/

    public Wall(){}

    public Wall(int x, int y, BufferedImage img, LazarusWorld world){
        super(false);
        this.x = x;
        this.y = y;
        this.img = img;
        this.world = world;
        WallRect = new Rectangle(x,y,img.getWidth(), img.getHeight());

        update();
    }

    public void draw(Graphics2D g){

        g.drawImage(img,x+2,y+2, null);

    }

    public void update(){
        world.setAllBoxOnMap(new Boxes(this.x, this.y, this.img, this.WallRect));
    }

    public Rectangle getWallRect(){
        return WallRect;
    }

}
