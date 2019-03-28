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
    protected int spawnPointX, spawnPointY;
    private int angle;
    private int speed;
    //private int up, down, left, right, shoot;
    private boolean goUp, goDown, goLeft, goRight, fire;
    private Tank p1, p2;
    private TankWorld world;
    private boolean isDead;
    private BufferedImage img;

    private final int ROTATIONSPEED = 4;

    public Tank(){
    }

    public Tank(TankWorld world, BufferedImage img, int x, int y, int speed /**int up, int down, int left, int right, int shoot*/){
        super(x,y,img);
        this.img = img;
        /**
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.shoot = shoot;
         */
        this.speed = speed;
        this.spawnPointX = x;
        this.spawnPointY = y;
        this.world = world;
    }

    public void setOtherTank(Tank otherTank){
        this.p1 = new Tank();
        this.p1 = this;
        this.p2 = new Tank();
        this.p2 = otherTank;
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

    public void update(){
        if(this.goUp){
            this.forward();
        }
        if(this.goDown){
            this.backward();
        }
        if(this.goLeft){
            this.rotateLeft();
        }
        if(this.goRight){
            this.rotateRight();
        }
    }

    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void forward(){
        x = (int) (x + Math.round(speed * Math.cos(Math.toRadians(angle))));
        y = (int) (y + Math.round(speed * Math.sin(Math.toRadians(angle))));
    }

    private void backward(){
        x = (int) (x - Math.round(speed * Math.cos(Math.toRadians(angle))));
        y = (int) (y - Math.round(speed * Math.sin(Math.toRadians(angle))));
    }

    public void draw(Graphics2D g){
        p1 = TankWorld.getTank(1);
        p2 = TankWorld.getTank(2);

        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        g.drawImage(img, rotation, null);
    }

    public int getTankCenterX(){
        return x + img.getWidth(null)/2;
    }

    public int getTankCenterY(){
        return x + img.getHeight(null)/2;
    }
    //get

    /**
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
    }*/
}
