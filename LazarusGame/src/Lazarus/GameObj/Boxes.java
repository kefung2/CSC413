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
    private boolean droping;;

    public Boxes(){
        droping = true;
    }

    public Boxes(boolean drop) {droping = drop;}

    public Boxes(int x, int y, BufferedImage img, Rectangle objRect){
        this.x = x;
        this.y = y;
        this.img = img;
        this.weight = 0;
        this.objRect = objRect;
    }

    public Boxes (int x, int y, int weight, BufferedImage img, LazarusWorld world, Rectangle objRect){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.img = img;
        this.world = world;
        this.objRect = objRect;

    }

    public void draw(Graphics2D g){
        g.drawImage(img,x, y, null);
        g.draw(objRect);
        //update();
    }

    public void update(){
        p1 = LazarusWorld.getP1();
        int p1x = p1.getXforColli();
        int p1y = p1.getY();
        if(p1.collision(objRect)){
            p1.setHitAWall(true);
            if(p1x+35 < x){
                System.out.println("Left " + x);
                p1.setX(p1.getPx());
            }else if(p1x > x+35){
                System.out.println("Right " + x);
                p1.setX(p1.getPx());
            }

        }
    }

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
