package Lazarus;

import Lazarus.GameObj.*;
import Lazarus.GameObj.Button;

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
    private ArrayList<String> boxList;
    private ArrayList<Boxes> allBoxonMap;
    private ArrayList<Boxes> boxInAir;
    private ArrayList<Button> buttons;
    private Boxes droppingBox;
    private boolean dropTheBox, boxDroping;


/*********************************************************************************************************************/

    public void DrawPanel(){}

    public DrawPanel(int fWidth, int fHeight, String imgPath, LazarusWorld world){
        super();
        frameHeight = fHeight;
        frameWidth = fWidth;
        BGPath = imgPath;
        bg = world.stringToBuffer(BGPath);
        this.world = world;
        dropTheBox = false;

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
        drawBox(g2);
        drawButton(g2);
        drawPlayer(g2);
        if(dropTheBox){
            drawdroppingbox(g2);
            dropTheBox = false;
        }
        screen = bimg;
    }

    public void drawBG(Graphics2D g){
        g.drawImage(bg ,2,2,this);
    }

    public void drawBox(Graphics2D g){
        allBoxonMap.forEach((curr) ->{
            curr.draw(g);
        });
    }

    public void drawdroppingbox(Graphics2D g){

        Graphics2D g2 = (Graphics2D) g;
        try {
            boxInAir.forEach((curr) -> {
                if(curr.getdroping())
                curr.draw(g);
            });
        }catch(ConcurrentModificationException e){

        }

/*        world.getBoxList().set(0,world.getBoxList().get(1));
        world.getBoxList().set(1,world.getBoxList().get(2));
        world.getBoxList().remove(2);*/
    }

    public void drawButton(Graphics2D g){
        buttons.forEach((curr) ->{
            curr.draw(g);
        });
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

    public void setBox(ArrayList<String> boxList){
        this.boxList = boxList;
    }

    public void setBoxonMap(ArrayList<Boxes> allBoxOnMap){this.allBoxonMap = allBoxOnMap;}

    public void setBoxInAir(ArrayList<Boxes> boxInAir){this.boxInAir = boxInAir;}

    public void setButtons(ArrayList<Button> button){this.buttons = button;}

    public void DropABox(){
        dropTheBox = true;
    }

    public boolean getDropsStatus(){
        return boxDroping;
    }
}
