package TankGame.GameObj;

import TankGame.TankWorld;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class Tank extends GameObj{

    protected int health = 100;
    protected int life = 3;
    protected int spawnPointP1, getSpawnPointP2;
    private int angle,x,y;
    private int up, down, left, right, shoot, speed;
    private boolean goUp, goDown, goLeft, goRight, fire;
    private Tank p1, p2;
    private TankWorld world;
    private boolean isDead;
    private BufferedImage img;

    public Tank(){
    }

    public Tank(TankWorld world, BufferedImage img, int x, int y, int speed, int up, int down, int left, int right, int shoot){
        this.img = img;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.shoot = shoot;
    }

    public void toggleGoUp(){
        this.goUp = true;
    }

    public void toggleGoDown(){
        this.goDown = true;
    }

    public void toggleGoLeft(){
        this.goLeft = true;
    }

    public void toggleGoRight(){
        this.goRight = true;
    }

    public void UntoggleGoUp(){
        this.goUp = false;
    }

    public void UntoggleGoDown(){
        this.goDown = false;
    }

    public void UntoggleGoLeft(){
        this.goLeft = false;
    }

    public void UntoggleGoRight(){
        this.goRight = false;
    }

    public void draw(Graphics2D g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        g.drawImage(img, rotation, null);
    }

    //get

    public int getUp() {
        return up;
    }

    public int getDown(){
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getShoot() {
        return shoot;
    }
}
