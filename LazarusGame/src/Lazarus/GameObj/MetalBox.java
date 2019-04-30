package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MetalBox implements GameObj{
    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle MBoxRect;

/*********************************************************************************************************************/

    public MetalBox(){}

    public MetalBox(int x, int y, int weight, BufferedImage img){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        MBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }

    @Override
    public boolean collision(Rectangle gameRect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g){

    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return MBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }

}

