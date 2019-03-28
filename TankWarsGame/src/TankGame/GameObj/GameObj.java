package TankGame.GameObj;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class GameObj extends JComponent{

    private BufferedImage img;
    public int x;
    public int y;


    public GameObj(){}

    public GameObj (int x, int y, BufferedImage img){
        this.img = img;
        this.x = x;
        this.y = y;
    }

}
