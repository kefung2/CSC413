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
//    private ArrayList<Wall> allWallBoxonMap;
//    private ArrayList<CardBoardBox> allCBoxonMap;
//    private ArrayList<WoodBox> allWBoxonMap;
//    private ArrayList<MetalBox> allMBoxonMap;
//    private ArrayList<StoneBox> allSBoxonMap;
    private ArrayList<CardBoardBox> CboxInAir;
    private ArrayList<WoodBox> WboxInAir;
    private ArrayList<MetalBox> MboxInAir;
    private ArrayList<StoneBox> SboxInAir;
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

        buttons = new ArrayList<>();
        CboxInAir = new ArrayList<>();
        WboxInAir = new ArrayList<>();
        MboxInAir = new ArrayList<>();
        SboxInAir = new ArrayList<>();

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
//        drawBox(g2); // the wall
        drawButton(g2);
        drawPlayer(g2);
        drawAllBox(g2);
//        drawCBox(g2);
//        drawWBox(g2);
//        drawMBox(g2);
//        drawSBox(g2);
        drawHUD(g2);

            drawdroppingCbox(g2);
            drawdroppingWbox(g2);
            drawdroppingMbox(g2);
            drawdroppingSbox(g2);

            //dropTheBox = false; reason why box drop and gone

        screen = bimg;

    }

    public void drawBG(Graphics2D g){
        g.drawImage(bg ,2,2,this);
    }

    public void drawHUD(Graphics2D g){
        ArrayList<BufferedImage> boxImage = new ArrayList<>();
        for(int i=0; i < boxList.size(); i++){
            if (boxList.get(i) == "Cbox") {
                boxImage.add(world.getCBoximg());
            } else if (boxList.get(i) == "Wbox") {
                boxImage.add(world.getWBoximg());
            } else if (boxList.get(i) == "Mbox") {
                boxImage.add(world.getMBoximg());
            } else if (boxList.get(i) == "Sbox") {
                boxImage.add(world.getSBoximg());
            }
        }

        g.setColor(Color.black);

        g.fillRect(0,480,640,40);

        for(int j = 0; j < boxImage.size(); j++){
            g.drawImage(boxImage.get(j),480 + (j*60) , 480, this);
        }
    }

//    public void drawBox(Graphics2D g){
//        allWallBoxonMap.forEach((curr) ->{
//            curr.draw(g);
//        });
//    }

    public void drawAllBox(Graphics2D g){
        try {
            allBoxonMap.forEach((curr) -> {
                curr.draw(g);
            });
        }catch (ConcurrentModificationException e){

        }
    }

    public void drawdroppingCbox(Graphics2D g){

        Graphics2D g2 = (Graphics2D) g;
        try {
            CboxInAir.forEach((curr) -> {
                if(curr.getdroping())
                curr.draw(g2);
            });
        }catch(ConcurrentModificationException | NullPointerException e){
            System.out.println("no box");
        }
    }

    public void drawdroppingWbox(Graphics2D g){

        Graphics2D g2 = (Graphics2D) g;
        try {
            WboxInAir.forEach((curr) -> {
                if(curr.getdroping())
                    curr.draw(g2);
            });
        }catch(ConcurrentModificationException | NullPointerException e){
            System.out.println("no box");
        }
    }

    public void drawdroppingMbox(Graphics2D g){

        Graphics2D g2 = (Graphics2D) g;
        try {
            MboxInAir.forEach((curr) -> {
                if(curr.getdroping())
                    curr.draw(g2);
            });
        }catch(ConcurrentModificationException | NullPointerException e){
            System.out.println("no box");
        }
    }

    public void drawdroppingSbox(Graphics2D g){

        Graphics2D g2 = (Graphics2D) g;
        try {
            SboxInAir.forEach((curr) -> {
                if(curr.getdroping())
                    curr.draw(g2);
            });
        }catch(ConcurrentModificationException | NullPointerException e){
            System.out.println("no box");
        }
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

    public void setCBoxInAir(ArrayList<CardBoardBox> CboxInAir){this.CboxInAir = CboxInAir;}

    public void setWBoxInAir(ArrayList<WoodBox> WboxInAir){this.WboxInAir = WboxInAir;}

    public void setMBoxInAir(ArrayList<MetalBox> MboxInAir){this.MboxInAir = MboxInAir;}

    public void setSBoxInAir(ArrayList<StoneBox> SboxInAir){this.SboxInAir = SboxInAir;}

    public void setButtons(ArrayList<Button> button){this.buttons = button;}

    public void DropABox(){
        dropTheBox = true;
    }
}
