package TankGame.GameObj;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class GameObj extends JComponent{

    private Rectangle rectangleObj;
    public BufferedImage img;
    public int x;
    public int y;
    public int width;
    public int height;
    public int speed;


    public GameObj(){}

    public GameObj (int x, int y, BufferedImage img){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth();
        this.height = img.getHeight();
        //this.rectangleObj = new Rectangle(x,y, this.width, this.height);
    }

    public GameObj (int x, int y, int width, int height, BufferedImage img){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.rectangleObj = new Rectangle(x,y, this.width, this.height);
    }

    public GameObj (int x, int y, BufferedImage img, int speed){
        this.x = x;
        this.y = y;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.img = img;
        this.speed = speed;
        //this.rectangleObj = new Rectangle(x,y, this.width, this.height);
    }

}
