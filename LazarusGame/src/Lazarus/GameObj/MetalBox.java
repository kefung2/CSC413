
package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MetalBox extends Boxes{
    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle MBoxRect;
    private LazarusWorld world;
    private boolean droping;
    private Wall wall;
    private Rectangle wallRect;


/*********************************************************************************************************************/


    public MetalBox(){}

    public MetalBox(int x, int y, int weight, BufferedImage img,LazarusWorld world){
        super(x,y,weight,img, world);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.droping = true;
        MBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }

    public boolean collision(Rectangle gameRect) {
        return false;
    }

    public void draw(Graphics2D g){
        g.drawImage(img,x+2,y+2, null);
        update();
    }

    public void update(){
        if(droping) {
            System.out.println("y++");
            y++;
            MBoxRect.setLocation(this.x, this.y);
        }
        for(int i = 0; i < world.getMapWall().size(); i++) {
            wall = world.getMapWall().get(i);
            wallRect = wall.getWallRect();
            System.out.println("Falling");
            System.out.println("Check: " + wallRect.intersects(MBoxRect));
            if (wallRect.intersects(MBoxRect)){
                System.out.println("Landed");
                droping = false;
                world.setDropping();
                world.getmapM().add(this);
                world.getMboxInAir().remove(this);
            }
        }
    }

    public void setDroping(){
        droping = true;
    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return MBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }
}

