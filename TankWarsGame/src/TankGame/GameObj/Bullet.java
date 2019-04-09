package TankGame.GameObj;

import TankGame.TankWorld;
import TankGame.GameObj.Tank;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Bullet extends GameObj{

    private Tank p1 = TankWorld.getTank(1);
    private Tank p2 = TankWorld.getTank(2);
    private BufferedImage bullet;
    private int bulletAngle;
    private int damage;
    private TankWorld world;
    public int xsize, ysize;
    public Tank shooter;
    public boolean visible;
    private Rectangle bulletRect;

    public Bullet(TankWorld world, BufferedImage img, int speed, Tank t, int damage){
        super(t.getTankCenterX(), t.getTankCenterY(),img, speed);
        bullet = img;
        this.damage = damage;
        xsize = img.getWidth(null);
        ysize = img.getHeight(null);
        shooter = t;
        bulletAngle = t.getAngle();
        visible = true;
        this.world = world;
        bulletRect = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void draw(ImageObserver iobs, Graphics2D g){

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


    }

}
