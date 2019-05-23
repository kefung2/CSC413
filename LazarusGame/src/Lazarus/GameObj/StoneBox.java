package Lazarus.GameObj;


import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StoneBox extends Boxes{
    private int x,y;
    private BufferedImage img;
    private int weight;
    private Rectangle SBoxRect;
    private LazarusWorld world;
    private boolean droping;
    private Player p1;
    private Rectangle wallRect;
    private Boxes box;

/*********************************************************************************************************************/

    public StoneBox(){}

    public StoneBox(int x, int y, int weight, BufferedImage img, LazarusWorld world, Player p1){
        super();
        this.x = x+2;
        this.y = y+2;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.p1 = p1;
        //this.droping = true;
        SBoxRect = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
    }

    public boolean collision(Rectangle gameRect) {
        return false;
    }


    public void draw(Graphics2D g){
        g.drawImage(img,x,y, null);
        update();
    }

    public void update(){
        if(droping) {
            System.out.println("y++");
            if(p1.getGodmode()){
                y += 2;
            }else{
                y++;
            }
            SBoxRect.setLocation(this.x, this.y);

            for (int i = 0; i < world.getAllBoxOnMap().size()-1; i++) {
                box = world.getAllBoxOnMap().get(i);
                wallRect = box.getObjRect();
                System.out.println("Falling");
                System.out.println("Check: " + wallRect.intersects(SBoxRect));
                if (wallRect.intersects(SBoxRect) && droping) {
                    if(this.weight > box.getWeight() && box.getWeight() != 0){
                        world.getAllBoxOnMap().remove(i);
                    }else {
                        SBoxLanded();
                    }
                }

                if(SBoxRect.intersects(p1.getLazaRect()) && droping){
                    p1.setDead();
                }
            }
        }

    }

    public void setDroping(){
        droping = true;
    }

    public boolean getdroping(){
        return droping;
    }

    public int getWeight(){
        return weight;
    }

    public Rectangle getRect(){
        return SBoxRect;
    }

    public void setX(int newX){
        this.x = newX;
    }

    public void SBoxLanded(){
        System.out.println("Landed");
        droping = false;
        world.setDropping();
        //world.getmapC().add(this);
        world.setAllBoxOnMap(new Boxes(this.x, this.y, this.weight, this.img, this.world, this.SBoxRect));
        world.getSboxInAir().clear();
    }
}
