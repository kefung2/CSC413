package TankGame.GameObj;

import TankGame.TankWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BreakableWall extends GameObj {
    private Rectangle BwallRect;
    private int width, height;
    private Tank p1,p2;
    private boolean dusted = false;

    //public UnBreakableWall(){}

    public  BreakableWall (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
        this.width = img.getWidth();
        this.height = img.getHeight();
        BwallRect = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){
        g.drawImage(this.img, this.x, this.y, this);
    }

    public Rectangle getWallRect(){
        return BwallRect;
    }

    public void dustedWall(){
        dusted = true;
    }

    public Rectangle getBwallRect(){
        return BwallRect;
    }

    public void update(){
        if(!dusted) {
            p1 = TankWorld.getTank(1);
            p2 = TankWorld.getTank(2);
            this.checkCollision(p1);
            this.checkCollision(p2);

        }
    } // update end

    public void checkCollision(Tank player){
        if(player.collision(BwallRect)){
            if(player.getRectOffsetX() < x){                //left side Tank, Right side wall
                System.out.println("Left " + x);
                player.x = player.getPx();
            }else if(player.x > x+32){                         //right side Tank, left side wall
                System.out.println("Right " + x);
                player.x = player.getPx();
            }
            if (player.y > y - 32) {                       //top side Tank, bottom side wall
                System.out.println("Top " + x);
                player.y = player.getPy();
            } else if (player.getRectOffsetY()< y) {       //bottom side Tank, top side wall
                System.out.println("Bottom " + x);
                player.y = player.getPy();
            }
        }
    }
}
