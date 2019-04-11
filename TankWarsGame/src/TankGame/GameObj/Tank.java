package TankGame.GameObj;

import TankGame.TankWorld;
import TankGame.GameObj.Bullet;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tank extends GameObj{

    protected int health = 100;
    protected int life = 3;
    protected int spawnPointX, spawnPointY;
    private int angle, px, py;
    private int speed;
    //private int up, down, left, right, shoot;
    private boolean goUp, goDown, goLeft, goRight, fire;
    private int fireCD = 20;
    private int fireRate = 0;
    private Tank p1, p2;
    private TankWorld world;
    private boolean isDead, touching;
    private BufferedImage img;
    private Rectangle tankRect;
    private int rectOffsetX = x+70;
    private int rectOffsetY = y-70;

    private final int ROTATIONSPEED = 4;

    public Tank(){
    }

    public Tank(TankWorld world, BufferedImage img, int x, int y, int speed){
        super(x,y,img);
        this.img = img;
        this.speed = speed;
        //this.spawnPointX = x;
        //this.spawnPointY = y;
        this.world = world;
        this.isDead = false;
        tankRect = new Rectangle(this.x-3, this.y-3, this.width+6, this.height+6);
        /**
         * tankRect Data:
         * x: 96 (x,y = top left corner), (x+64, y-64 = bottom right corner)
         * y: 64
         * width: 64
         * height: 64
         *
         */
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

    public void toggleShoot(){ this.fire = true;}

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

    public void UntoggleShoot() {this.fire = false;}

    public void update(){
        if(this.goUp){
            this.forward();
            System.out.println("x location: "+x+" y location: "+y+ "angle: " + angle ); /**    REMOVE ME     */

        }
        if(this.goDown){
            this.backward();
            System.out.println("x location: "+x+" y location: "+y+ "angle: " + angle ); /**     REMOVE ME    */

        }
        if(this.goLeft){
            this.rotateLeft();
        }
        if(this.goRight){
            this.rotateRight();
        }
        if(this.fire){
            shoot(this);
        }

    }

    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void forward(){


        if (!touching) {
            px = x;
            py = y;
            x = (int) (x + Math.round(speed * Math.cos(Math.toRadians(angle))));
            y = (int) (y + Math.round(speed * Math.sin(Math.toRadians(angle))));
            tankRect.setLocation(x-3, y-3);
        }else{
            x = (int) (x + Math.round(speed * Math.cos(Math.toRadians(angle))));
            y = (int) (y + Math.round(speed * Math.sin(Math.toRadians(angle))));
            tankRect.setLocation(x-3, y-3);
        }
    }

    private void backward(){

        if(!touching) {
            px = x;
            py = y;
            x = (int) (x - Math.round(speed * Math.cos(Math.toRadians(angle))));
            y = (int) (y - Math.round(speed * Math.sin(Math.toRadians(angle))));
            tankRect.setLocation(x-3, y-3);
        }else{
            x = (int) (x + Math.round(speed * Math.cos(Math.toRadians(angle))));
            y = (int) (y + Math.round(speed * Math.sin(Math.toRadians(angle))));
            tankRect.setLocation(x-3, y-3);
        }
    }

    private void shoot(Tank a){

        if (fire && fireRate <= 0) {
            Bullet shot = new Bullet(this.world, world.getBulletImg(), 9, this);
            world.getBulletList().add(shot);
            this.fireRate = fireCD;
        }

    }

    public void draw(Graphics2D g){
        p1 = TankWorld.getTank(1);
        p2 = TankWorld.getTank(2);
        fireRate -= 1;

        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        g.draw(tankRect);
        g.drawImage(img, rotation, null);

    }

    public boolean collision (Rectangle gameObj){

        if(tankRect.intersects(gameObj)) {
            System.out.println("Touching"); /**     REMOVE ME    */
            touching = true;
            return true;

        }
        touching = false;
        return false;
    }

    public boolean KYSCheck(Tank shooter){
        if(shooter == this){
            return true;
        }
        return false;
    }


    public int getTankCenterX(){
        return x + img.getWidth()/2;
    }

    public int getTankCenterY(){
        return y + img.getHeight()/2;
    }
    //get

    public int getAngle(){
        return angle;
    }

    public int getHealth(){
        return health;
    }

    public int getLifes(){
        return life;
    }

    public int getFireCD(){ return fireCD;}

    public int getRectOffsetX(){
        return rectOffsetX;
    }

    public int getRectOffsetY(){
        return rectOffsetY;
    }

    public int getPx(){
        return px;
    }

    public int getPy(){
        return py;
    }

    public void setFireCD() {this.fireCD = 10;}

    public boolean getDead(){
        return isDead;
    }

    public void setDead(){ this.isDead = true;}

    public void setLife(){
        this.life--;
    }

    public void takeDamge(){
        this.health = health - 25;
    }

}
