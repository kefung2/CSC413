package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player implements GameObj {

    private int x, y, r, angle, px, py;
    private BufferedImage img;
    private Rectangle lazaRect;
    private LazarusWorld world;
    private int RectOffsetX, RectOffsetY;

    private boolean isDead;
    private int lives;

    private Boxes box;
    private Rectangle boxRect;

    private boolean goLeft, goRight, hitAWall;

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
        this.r = 40;
        this.angle = 0;
        this.hitAWall = false;
        lazaRect = new Rectangle(this.x, this.y-2, img.getWidth(), img.getHeight());
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
            this.moveLeft();
            System.out.println("left");
        }
        if (this.goRight) {
            this.moveRight();
            System.out.println("right");
        }
    }

    private void moveLeft(){
          px = x;
//
//        collisionCheck();
//
//        if(!hitAWall){
//            x--;
//            lazaRect.setLocation(this.x, this.y+3);
//        }
        x--;
        lazaRect.setLocation(this.x, this.y+3);

    }

    private void moveRight(){
          px = x;
//
//        collisionCheck();
//
//        if(!hitAWall){
//            x++;
//            lazaRect.setLocation(this.x, this.y+3);
//        }
        x++;
        lazaRect.setLocation(this.x, this.y+5);
    }

    private void jump(){}

    private void collisionCheck(){
        for(int i = 0; i < world.getAllBoxOnMap().size(); i++){
            box = world.getAllBoxOnMap().get(i);
            boxRect = box.getObjRect();
            if(lazaRect.intersects(boxRect)){
                x = px;
                lazaRect.setLocation(this.x, this.y+5);
                hitAWall = false;
            }else {
                hitAWall = false;
            }
        }
    }


    @Override
    public boolean collision(Rectangle gameRect) {
        if(lazaRect.intersects(gameRect)){
            return true;
        } else {return false;}
    }

    @Override
    public void draw(Graphics2D g){
        g.drawImage(img,x,y, null);
        g.draw(lazaRect);
    }
    /*****************************************************************************************************************/
    // get/set

    public int getX(){
        int z=x+img.getWidth()/2;
        if(0 <= z && z < 40) {
            return 0;
        }else if(41 <= z && z < 80) {
            return 40;
        }else if(81 <= z && z < 120) {
            return 80;
        }else if(121 <= z && z < 160) {
            return 120;
        }else if(161 <= z && z < 200) {
            return 160;
        }else if(201 <= z && z < 240) {
            return 200;
        }else if(241 <= z && z < 280) {
            return 240;
        }else if(281 <= z && z < 320) {
            return 280;
        }else if(321 <= z && z < 360) {
            return 320;
        }else if(361 <= z && z < 400) {
            return 360;
        }else if(401 <= z && z < 440) {
            return 400;
        }else if(441 <= z && z < 480) {
            return 440;
        }else if(481 <= z && z < 520) {
            return 480;
        }else if(521 <= z && z < 560) {
            return 520;
        }else if(561 <= z && z < 600) {
            return 560;
        }else if(601 <= z && z < 640) {
            return 600;
        }else
//        else if(641 <= x && x < 6) {
//            return 640;
//        }
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

    public int getPx(){ return px;}

    public int getRectOffsetX(){
        return RectOffsetX;
    }

    public Rectangle getLazaRect() {
        return lazaRect;
    }
}
