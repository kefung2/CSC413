package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WoodBox extends Boxes{
    private int x,y;
    private BufferedImage img;
    private boolean droping;
    private int weight;
    private Rectangle WBoxRect;
    private LazarusWorld world;
    private Boxes boxes;
    private Rectangle boxRect;

/*********************************************************************************************************************/
    public WoodBox(){}

    public WoodBox(int x, int y, int weight, BufferedImage img, LazarusWorld world){
        super(x,y,weight,img, world,true);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.droping = true;
        WBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }


    public boolean collision(Rectangle gameRect) {
        return false;
    }


    public void draw(Graphics2D g){
        g.drawImage(img,x+2,y+2, null);
        super.update();
    }


    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return WBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }
}
