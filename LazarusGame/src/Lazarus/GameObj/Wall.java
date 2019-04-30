package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall implements GameObj{

    int x,y;
    private BufferedImage img;

/*********************************************************************************************************************/

    public Wall(){}

    public Wall(int x, int y, BufferedImage img){}

    @Override
    public boolean collision(Rectangle gameRect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g){

    }

}
