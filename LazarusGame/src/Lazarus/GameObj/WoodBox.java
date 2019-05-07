package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WoodBox extends Boxes{
    private int x,y;
    private BufferedImage img;
    private boolean droping;
    private int weight;
    private Rectangle WBoxRect;
    private LazarusWorld world;
    private Boxes boxes;
    private Rectangle boxRect;
    private Wall wall;
    private Rectangle wallRect;
    private CardBoardBox CBox;

/*********************************************************************************************************************/
    public WoodBox(){}

    public WoodBox(int x, int y, int weight, BufferedImage img, LazarusWorld world){
        super(x,y,weight,img, world);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.droping = true;
        WBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
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
            WBoxRect.setLocation(this.x, this.y);
        }
        for(int i = 0; i < world.getMapWall().size(); i++) {
            wall = world.getMapWall().get(i);
            wallRect = wall.getWallRect();
            System.out.println("Falling");
            System.out.println("Check: " + wallRect.intersects(WBoxRect));
            if (wallRect.intersects(WBoxRect)){
                System.out.println("Landed");
                droping = false;
                world.setDropping();
                world.getmapW().add(this);
                world.getWboxInAir().remove(this);
            }
        }

//        for (int j = 0; j < world.getmapC().size(); j++) {
//            CBox = world.getmapC().get(j);
//            wallRect = CBox.getRect();
//            System.out.println("Falling");
//            System.out.println("Check: " + wallRect.intersects(WBoxRect));
//            if (wallRect.intersects(WBoxRect)) {
//                System.out.println("Landed");
//                droping = false;
//                world.setDropping();
//                world.getmapW().add(this);
//                world.getWboxInAir().remove(this);
//            }
//        }
    }

    public void setDroping(){
        droping = true;
    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return WBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }
}
