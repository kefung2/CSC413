package Lazarus.GameObj;


import java.awt.*;
import java.awt.image.BufferedImage;

public class StoneBox implements GameObj{
    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle SBoxRect;

/*********************************************************************************************************************/

    public StoneBox(){}

    public StoneBox(int x, int y, int weight, BufferedImage img){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        SBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
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
        return SBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }
}
