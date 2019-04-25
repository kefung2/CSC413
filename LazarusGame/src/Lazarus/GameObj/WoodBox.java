package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WoodBox implements GameObj{
    int x,y;
    BufferedImage img;
    int weight;

/*********************************************************************************************************************/

    public void WoodBox(){}

    public void WoodBox(int x, int y, int weight, BufferedImage img){}

    @Override
    public boolean collision(Rectangle gameRect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g){

    }
}
