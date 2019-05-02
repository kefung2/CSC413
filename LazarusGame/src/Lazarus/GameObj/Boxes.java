package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Boxes {

    private Rectangle objRect;
    public BufferedImage img;
    private int x,y;
    private int weight;
    private LazarusWorld world;
    private boolean droping;
    private Boxes boxes;
    private Rectangle boxRect;

    public Boxes(){}

    public Boxes (int x, int y, int weight, BufferedImage img, LazarusWorld world){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.objRect = new Rectangle(x,y,img.getWidth(), img.getHeight());

    }

    public void draw(Graphics2D g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x,y);
        g.drawImage(img,rotation, null);
        System.out.println(this + " --> " + x + "," + y);
        update();
    }

    public void update(){
        if(droping) {
            y++;
        }
        for(int i = 0; i < world.getAllBoxOnMap().size(); i++) {
            boxes = world.getAllBoxOnMap().get(i);
            boxRect = boxes.getObjRect();
            if (objRect.intersects(boxRect)){
                System.out.println("Landed");
                droping = false;
                world.setDropping();
                world.setAllBoxOnMap(this.x, this.y, this.img);
            }
        }
    }

    public Rectangle getObjRect(){
        return objRect;
    }

    public void setDroping(){
        droping = true;
    }

    public boolean getdroping(){
        return droping;
    }
}
