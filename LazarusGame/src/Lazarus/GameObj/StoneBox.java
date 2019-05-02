package Lazarus.GameObj;


import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StoneBox extends Boxes{
    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle SBoxRect;
    private LazarusWorld world;
    private boolean droping;
    private Boxes boxes;
    private Rectangle boxRect;

/*********************************************************************************************************************/

   /* public StoneBox(){}

    public StoneBox(int x, int y, int weight, BufferedImage img, LazarusWorld world){
        super(x,y,weight,img);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.droping = true;
        SBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }

    public boolean collision(Rectangle gameRect) {
        return false;
    }


    public void draw(Graphics2D g){

    }

    public void update(){
        if(droping) {
            y -= 1;
        }
        for(int i = 0; i < world.getAllBoxOnMap().size(); i++) {
            boxes = world.getAllBoxOnMap().get(i);
            boxRect = boxes.getObjRect();
            if (boxRect.intersects(SBoxRect)){
                droping = false;
                world.setAllBoxOnMap(this.x, this.y, this.img);
            }
        }
    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return SBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }*/
}
