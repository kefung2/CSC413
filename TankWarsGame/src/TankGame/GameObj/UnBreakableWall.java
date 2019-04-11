package TankGame.GameObj;

import TankGame.TankWorld;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class UnBreakableWall extends GameObj{
    private Rectangle wallRect;
    private int width, height;
    private Tank p1,p2;

    //public UnBreakableWall(){}

    public  UnBreakableWall (int x, int y, int width, int height, BufferedImage img){
        super(x,y,width,height,img);
        this.width = img.getWidth();
        this.height = img.getHeight();
        wallRect = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){

        g.drawImage(this.img, this.x, this.y, this);

    }

    public Rectangle getWallRect() {
        return wallRect;
    }

    public void update(){
        p1 = TankWorld.getTank(1);
        p2 = TankWorld.getTank(2);

        if(p1.collision(wallRect)){
            if(p1.getRectOffsetX() < x){   //left side Tank, Right side wall
                System.out.println("Left " + x);
                p1.x = p1.getPx();
            }else if(p1.x > x+32){                         //right side Tank, left side wall
                System.out.println("Right " + x);
                p1.x = p1.getPx();
            }
            if (p1.y > y - 32) {   //top side Tank, bottom side wall
                System.out.println("Top " + x);
                p1.y = p1.getPy();
            } else if (p1.getRectOffsetY()< y) {                         //bottom side Tank, top side wall
                System.out.println("Bottom " + x);
                p1.y = p1.getPy();
            }
        }
        if(p2.collision(wallRect)){
            if(p2.getRectOffsetX() < x){   //left side Tank, Right side wall
                System.out.println("Left " + x);
                p2.x = p2.getPx();
            }else if(p2.x > x+32){                         //right side Tank, left side wall
                System.out.println("Right " + x);
                p2.x = p2.getPx();
            }
            if (p2.y > y - 32) {   //top side Tank, bottom side wall
                System.out.println("Top " + x);
                p2.y = p2.getPy();
            } else if (p2.getRectOffsetY()< y) {                         //bottom side Tank, top side wall
                System.out.println("Bottom " + x);
                p2.y = p2.getPy();
            }
        }
    }

}
/**********************************************************************************************************************/
/** x1 = x , y1 = y
 *  x2 = x + offset , y2 = y - offset
 * __________________________________   _____________________________________
 * |(x1,y1)                   (x2,y1)|  |(x1,y1)                      (x2,y1)|
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |                                 |  |                                    |
 * |(x1,y2)                   (x2,y2)|  |(x1,y2)                      (x2,y2)|
 * -----------------------------------  --------------------------------------
 */
