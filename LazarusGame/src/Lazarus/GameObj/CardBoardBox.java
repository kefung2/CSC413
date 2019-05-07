
package Lazarus.GameObj;

import Lazarus.LazarusWorld;
import Lazarus.GameObj.Wall;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CardBoardBox extends Boxes{

    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle CBoxRect;
    private LazarusWorld world;
    private boolean droping;
    private Wall wall;
    private CardBoardBox CBox;
    private Boxes box;
    private Rectangle wallRect;


/*********************************************************************************************************************/


    public CardBoardBox(){}

    public CardBoardBox(int x, int y, int weight, BufferedImage img, LazarusWorld world){
        super(x,y,weight,img, world);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        //droping = true;
        CBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());

    }

    public boolean collision(Rectangle gameRect) {
        return false;
    }


    public void draw(Graphics2D g){
        g.drawImage(img,x+2,y+2, null);
        System.out.println(this + " --> " + x + "," + y);
        update();
    }

    public void update(){
        if(droping) {
            System.out.println("y++");
            y++;
            CBoxRect.setLocation(this.x, this.y);

            for (int i = 0; i < world.getMapWall().size(); i++) {
                wall = world.getMapWall().get(i);
                wallRect = wall.getWallRect();
                System.out.println("Falling");
                System.out.println("Check: " + wallRect.intersects(CBoxRect));
                if (wallRect.intersects(CBoxRect)) {
                    System.out.println("Landed");
                    droping = false;
                    world.setDropping();
                    world.getmapC().add(this);
                    world.getCboxInAir().remove(this);
                }
            }

//            for (int i = 0; i < world.getAllBoxOnMap().size(); i++) {
//                box = world.getAllBoxOnMap().get(i);
//                wallRect = box.getObjRect();
//                System.out.println("Falling");
//                System.out.println("Check: " + wallRect.intersects(CBoxRect));
//                if (wallRect.intersects(CBoxRect)) {
//                    System.out.println("Landed");
//                    droping = false;
//                    world.setDropping();
//                    //world.getmapC().add(this);
//                    world.setAllBoxOnMap(this);
//                    world.getCboxInAir().remove(this);
//                }
//            }

//            for (int j = 0; j < world.getmapC().size(); j++) {
//                CBox = world.getmapC().get(j);
//                wallRect = CBox.getRect();
//                System.out.println("Falling");
//                System.out.println("Check: " + wallRect.intersects(CBoxRect));
//                if (wallRect.intersects(CBoxRect)) {
//                    System.out.println("Landed");
//                    droping = false;
//                    world.setDropping();
//                    world.getmapC().add(this);
//                    world.getCboxInAir().remove(this);
//                }
//            }
        }
    }

    public void setDroping(){
        droping = true;
    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return CBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }
}

