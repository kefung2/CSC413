package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Player implements GameObj {

    private int x, y;
    private BufferedImage img;
    private Rectangle lazaRect;
    private LazarusWorld world;

    private boolean isDead;
    private int lives;

    private boolean goLeft, goRight;

/*********************************************************************************************************************/

    public Player() {
    }

    public Player(int x, int y, BufferedImage img, LazarusWorld world) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.world = world;
        this.isDead = false;
        this.lives = 3;
        lazaRect = new Rectangle();
    }

    public void toggleGoLeft() {
        this.goLeft = true;
    }

    public void toggleGoRight() {
        this.goRight = true;
    }

    public void UntoggleGoLeft() {
        this.goLeft = false;
    }

    public void UntoggleGoRight() {
        this.goRight = false;
    }

    public void update() {

        if (this.goLeft) {
        }
        if (this.goRight) {
        }
    }


    @Override
    public boolean collision(Rectangle gameRect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g){

        g.drawImage(img,x,y, null);
    }
    /*****************************************************************************************************************/
    // get/set

    public int getX(){
        return x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY(){
        return y;
    }

    public void setY(int newY){
        this.y = newY;
    }
}
