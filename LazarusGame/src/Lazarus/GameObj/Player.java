package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player implements GameObj {

    private int x, y, r, angle, px, py;
    private BufferedImage img;
    private Image animation;
    private Rectangle lazaRect;
    private LazarusWorld world;
    private int RectOffsetX, RectOffsetY;

    private boolean isDead;
    private int lives;

    private Boxes box;
    private Rectangle boxRect, jumpRect;

    private boolean goLeft, goRight, goUp, goDown, hitAWall, ready, jump;

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
        lazaRect = new Rectangle(this.x, this.y-3, img.getWidth(), img.getHeight());
        jumpRect = new Rectangle(this.x, this.y-3, img.getWidth(), img.getHeight());
    }

    public void toggleGoLeft() {
        this.goLeft = true;
    }

    public void toggleGoRight() {
        this.goRight = true;
    }

    public void toggleGoUp(){
        this.goUp = true;
    }

    public void toggleGoDown(){
        this.goDown = true;
    }

    public void UntoggleGoLeft() {
        this.goLeft = false;
    }

    public void UntoggleGoRight() {
        this.goRight = false;
    }

    public void UntoggleGoUp(){
        this.goUp = false;
    }

    public void UntoggleGoDown(){
        this.goDown = false;
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
//        if (this.goUp) {
//            y--;
//            System.out.println("up");
//        }
//        if (this.goDown) {
//            y++;
//            System.out.println("down");
//        }
        //collisionCheck();
    }

    private void moveLeft(){
        px = x;

        if(!(hitAWall)) {
            x--;
            lazaRect.setLocation(this.x, this.y - 3);
            jumpRect.setLocation(this.x - 40, this.y - 43);
            if (ready && jump) {
                jump("left");
            }
        }
    }

    private void moveRight(){
          px = x;

        if(!(hitAWall)) {
              x++;
              lazaRect.setLocation(this.x, this.y-3);
              jumpRect.setLocation(this.x+40, this.y-43);
          if(ready && jump){
            jump("right");
            }
        }
    }

    private void jump(String direction){
        System.out.println("trying to jump");
        if(direction == "left") {
            this.x = x - 40;
            this.y = y - 40;
        }
            if (direction == "right") {
                this.x = x + 40;
                this.y = y - 40;
            }

    }

    private void collisionCheck(){

        for(int i = 0; i < world.getAllBoxOnMap().size(); i++){
            System.out.println("I'm in");
            box = world.getAllBoxOnMap().get(i);
            boxRect = box.getObjRect();
            //System.out.println("jump Check: " + hitAWall + " " + !(jumpRect.intersects(boxRect)));
            if(lazaRect.intersects(boxRect)){
                ready = true;
            } else {
                ready = false;
            }

            if(!(jumpRect.intersects(boxRect))){
                System.out.println("I can jump");
                jump = true;
            } else{
                jump = false;
            }
        }
    }


    @Override
    public boolean collision(Rectangle gameRect) {
        if(lazaRect.intersects(gameRect)){
            System.out.println("Touching");
            //hitAWall = true;
            return true;
        } else {
            hitAWall = false;
            return false;
        }
    }

    @Override
    public void draw(Graphics2D g){
        if(!isDead /*&& !goLeft && !goRight*/) {
            g.drawImage(img, x, y, null);
            g.draw(lazaRect);
            g.draw(jumpRect);
        }

        if(isDead){
            animation = world.getSquishedgif();
            g.drawImage(animation, x, y, animation.getWidth(null), animation.getHeight(null), null);
        }
//        if(goLeft){
//            animation = world.getMoveLeftgif();
//            g.drawImage(animation, x, y+10, animation.getWidth(null), animation.getHeight(null), null);
//        }
//        if(goRight){
//            animation = world.getMoveRightgif();
//            g.drawImage(animation, x, y+10, animation.getWidth(null), animation.getHeight(null), null);
//        }
    }
    /*****************************************************************************************************************/
    // get/set

    public int getX(){
        int z=x+img.getWidth()/2;
        if(0 <= z && z < 40) {
            return 0;
        }else if(41 <= z && z < 80) {
            return 40-4;
        }else if(81 <= z && z < 120) {
            return 80-4;
        }else if(121 <= z && z < 160) {
            return 120-4;
        }else if(161 <= z && z < 200) {
            return 160-4;
        }else if(201 <= z && z < 240) {
            return 200-4;
        }else if(241 <= z && z < 280) {
            return 240-4;
        }else if(281 <= z && z < 320) {
            return 280-4;
        }else if(321 <= z && z < 360) {
            return 320-4;
        }else if(361 <= z && z < 400) {
            return 360-4;
        }else if(401 <= z && z < 440) {
            return 400-4;
        }else if(441 <= z && z < 480) {
            return 440-4;
        }else if(481 <= z && z < 520) {
            return 480-4;
        }else if(521 <= z && z < 560) {
            return 520-4;
        }else if(561 <= z && z < 600) {
            return 560-4;
        }else if(601 <= z && z < 640) {
            return 600-4;
        }else
//        else if(641 <= x && x < 6) {
//            return 640;
//        }
        return x;
    }

    public int getXforColli(){
        return  x;
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

    public Rectangle getLazaRect() {
        return lazaRect;
    }

    public void setHitAWall(boolean hit) {hitAWall = hit;}

    public void setDead() {isDead = true;}

    public boolean getDead() {return isDead;}
}
