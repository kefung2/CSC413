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
    private Player p1;
    private boolean droping;
    private Wall boxes;
    private Rectangle boxRect;

    public Boxes(){
        droping = true;
    }

    public Boxes(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        this.weight = 0;
        this.p1 = p1;
        objRect = new Rectangle(x+2,y+2,img.getWidth(), img.getHeight());
    }

    public Boxes (int x, int y, int weight, BufferedImage img, LazarusWorld world, Rectangle objRect){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.p1 = p1;
        this.objRect = objRect;

    }

    public void draw(Graphics2D g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x,y);
        g.drawImage(img,x+2, y+2, null);
        g.draw(objRect);
        //System.out.println(this + " --> " + x + "," + y);
        //update();
    }

//    public void update(){
//        p1 = LazarusWorld.getP1();

//        if(p1.collision(objRect)){
//            if(p1.getX()+50 < x){
//                System.out.println("Left " + x);
//                p1.setX(p1.getPx());
//            }else if(p1.getX() > x+32){
//                System.out.println("Right " + x);
//                p1.setX(p1.getPx());
//            }
//        }
//    }

    public Rectangle getObjRect(){
        return objRect;
    }

    public int getWeight(){
        return this.weight;
    }

    public boolean getdroping(){
        return droping;
    }
}
