package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button implements GameObj{

    int x,y;
    private BufferedImage img;
    private Player p1;
    private boolean levelup;
    private Rectangle lvupRect;

    public Button(){}

    public Button(int x, int y, BufferedImage img){
        this.x = x+2;
        this.y = y+2;
        this.img = img;
        levelup = false;
        lvupRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
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

        g.drawImage(img,x,y,null);
        g.draw(lvupRect);
    }

    public void update(){
        p1 = LazarusWorld.getP1();

        if(p1.collision(lvupRect)){
            levelup = true;
        }
    }
}
