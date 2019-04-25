package Lazarus;

import Lazarus.GameObj.Player;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class DrawPanel extends JPanel{

    private int frameWidth, frameHeight;
    private String BGPath;
    private BufferedImage bg, screen;
    private LazarusWorld world;
    private Player p1;


/*********************************************************************************************************************/

    public void DrawPanel(){}

    public DrawPanel(int fWidth, int fHeight, String imgPath, LazarusWorld world){
        super();
        frameHeight = fHeight;
        frameWidth = fWidth;
        BGPath = imgPath;
        bg = world.stringToBuffer(BGPath);
        this.world = world;

        setSize(frameWidth,frameHeight);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        getGameImage();
        g.drawImage(screen,0,0,this);
    }

    public void getGameImage(){
        BufferedImage bimg = new BufferedImage(frameWidth,frameHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bimg.createGraphics();

        drawBG(g2);
        drawPlayer(g2);
        screen = bimg;
    }

    public void drawBG(Graphics2D g){
        g.drawImage(bg ,2,2,this);
    }

    public void drawPlayer(Graphics2D g){
        Graphics2D gz = (Graphics2D) g;
        this.p1.draw(gz);

    }

    /*****************************************************************************************************************/
    //get/set

    public void setP1(Player p1){
        this.p1 = p1;
    }
}
