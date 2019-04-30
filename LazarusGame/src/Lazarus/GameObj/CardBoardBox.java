package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CardBoardBox implements GameObj{

    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle CBoxRect;

/*********************************************************************************************************************/

    public CardBoardBox(){}

    public CardBoardBox(int x, int y, int weight, BufferedImage img){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        CBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());

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
        return CBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }

}
