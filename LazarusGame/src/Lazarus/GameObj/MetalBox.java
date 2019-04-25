package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MetalBox implements GameObj{
    int x,y;
    BufferedImage img;
    int weight;

/*********************************************************************************************************************/

    public void MetalBox(){}

    public void MetalBox(int x, int y, int weight, BufferedImage img){}

    @Override
    public boolean collision(Rectangle gameRect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g){

    }

}

