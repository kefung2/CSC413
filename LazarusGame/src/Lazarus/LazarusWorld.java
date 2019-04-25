package Lazarus;

import Lazarus.GameObj.Player;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LazarusWorld extends JComponent {
    //values

    //Frame Values
    private int fWidth = 660;  //640
    private int fHeight = 520; // 480

    //Resource
    private String player;
    private String background;
    private String jumpleft;
    private String jumpright;
    private String squished;
    private String cardboardbox;    // all box dimension 40x40
    private String metalbox;
    private String woodbox;
    private String stonebox;
    private String buttom;
    private String wall;

    //Game Element
    private Player p1;

    //Draw
    private DrawPanel drawpanel;

    /**********************************************************************************************************/
    //main function

    public void LazarusWorld(){}

    public void init(){
        setResourcePath();
        this.drawpanel = new DrawPanel(fWidth,fHeight, background, this);

        setFrame();
        setPlayer();
    }

    public void startGame(){
        init();
        try{
            while(true) {
                //update();
                this.drawpanel.repaint();

                Thread.sleep(1000/144);
            }

        } catch (InterruptedException ignored){

        }
    }

    public void stop(){}

    //public void update(){}

    /*********************************************************************************************************/
    //set up
     public void setResourcePath(){
         background = "Resource/Background.bmp";
         player = "Resource/Lazarus_stand.gif";
         jumpleft = "Resource/Lazarus_left.gif";
         jumpright = "Resource/Lazarus_right.gif";
         squished = "Resource/Lazarus_squished.gif";
         cardboardbox = "Resource/CardBox.gif";
         woodbox = "Resource/WoodBox.gif";
         metalbox = "Resource/MetalBox.gif";
         stonebox = "Resource/StoneBox.gif";
         buttom = "Resource/Button.gif";
         wall = "Resource/Wall.gif";
     }

     public void setFrame(){
         JFrame jFrame = new JFrame();
         jFrame.setTitle("Lazarus");
         jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jFrame.add(this.drawpanel);
         jFrame.setSize(fWidth,fHeight);

         jFrame.setVisible(true);
     }

     public void setPlayer(){
         BufferedImage img = stringToBuffer(player);

         p1 = new Player(5,5,img,this);
         drawpanel.setP1(p1);

     }

    public BufferedImage stringToBuffer(String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Image not found");
        }
        return img;
    }


    /*********************************************************************************************************/
    // get/set


}
