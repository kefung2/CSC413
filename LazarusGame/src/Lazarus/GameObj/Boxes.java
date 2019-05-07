package Lazarus.GameObj;

import Lazarus.LazarusWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Boxes extends JComponent {

    private Rectangle objRect;
    public BufferedImage img;
    private int x,y;
    private int weight;
    private LazarusWorld world;
    private boolean droping;
    private Wall boxes;
    private Rectangle boxRect;

    public Boxes(){}

    public Boxes (int x, int y, int weight, BufferedImage img, LazarusWorld world){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.droping = true;
        this.objRect = new Rectangle(x,y,img.getWidth(), img.getHeight());

    }

    public void draw(Graphics2D g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x,y);
        g.drawImage(img,x+2, y+2, null);
        //System.out.println(this + " --> " + x + "," + y);
        //update();
    }

    public void update(){
        if(droping) {
            //System.out.println("y++");
            y--;
            objRect.setLocation(this.x, this.y);
        }
        for(int i = 0; i < world.getMapWall().size(); i++) {
            boxes = world.getMapWall().get(i);
            boxRect = boxes.getWallRect();
            System.out.println("Falling");
            if (objRect.intersects(boxRect)){
                System.out.println("Landed");
                droping = false;
                world.setDropping();
                world.setAllBoxOnMap(this);
            }
        }
    }

    public Rectangle getObjRect(){
        return objRect;
    }

    public boolean getdroping(){
        return droping;
    }
}
