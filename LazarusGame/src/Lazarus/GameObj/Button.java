package Lazarus.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button implements GameObj{

    int x,y;
    private BufferedImage img;
    private boolean levelup;

    public Button(){}

    public Button(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        levelup = false;
    }

    public boolean getLevelup(){
        return levelup;
    }

    public void setLevelup() {
        levelup = false;
    }

    @Override
    public boolean collision(Rectangle rect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img,x+2,y+2,null);
    }
}
