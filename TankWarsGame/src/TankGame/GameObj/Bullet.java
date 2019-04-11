package TankGame.GameObj;

import TankGame.TankWorld;
import TankGame.GameObj.Tank;
import TankGame.GameObj.UnBreakableWall;
import TankGame.GameObj.BreakableWall;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet extends GameObj{

    private Tank p1 = TankWorld.getTank(1);
    private Tank p2 = TankWorld.getTank(2);
    private BufferedImage bullet;
    private int bulletAngle;
    private TankWorld world;
    public int xsize, ysize;
    public Tank shooter;
    public boolean visible;
    private Rectangle bulletRect, UBWRect, BWRect;
    UnBreakableWall UBW;
    BreakableWall BW;

    public Bullet(TankWorld world, BufferedImage img, int speed, Tank t){
        super(t.getTankCenterX(), t.getTankCenterY(),img, speed); // bullet 24x24
        bullet = img;
        xsize = img.getWidth();
        ysize = img.getHeight();
        shooter = t;
        bulletAngle = t.getAngle();
        visible = true;
        this.world = world;
        bulletRect = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void draw(Graphics2D g){

        //abullet = bullet.;
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(bulletAngle), 0,0);
        g.drawImage(bullet, rotation, null);
        update();
    }

    @Override
    public boolean isVisible(){
        return this.visible;
    }

    public void update(){
        x += Math.round(speed*Math.cos(Math.toRadians(bulletAngle)));
        y += Math.round(speed*Math.sin(Math.toRadians(bulletAngle)));
        bulletRect.setLocation(x,y);

        //System.out.println(shooter + " fired!");

        if(p1.collision(bulletRect) && shooter != p1){
                world.getBulletList().clear();
                p1.takeDamge();
        }

        if(p2.collision(bulletRect) && shooter != p2){
            world.getBulletList().clear();
            p2.takeDamge();
        }


        //Check collision w/ Unbreakable walls
        for(int i = 0; i<world.getUBWsize() ;i++) {
            UBW = world.getUBW().get(i);
            UBWRect = UBW.getWallRect();
            if (UBWRect.intersects(bulletRect)){
                world.getBulletList().clear();
            }
        }

        //Check collision w/ Breakable Walls
        for(int j = 0; j<world.getBWsize(); j++){
            BW = world.getBW().get(j);
            BWRect = BW.getWallRect();
            if (BWRect.intersects(bulletRect)){
                world.getBulletList().clear();
                world.getBW().remove(j);
                BW.dustedWall();
            }
        }



    }

}
