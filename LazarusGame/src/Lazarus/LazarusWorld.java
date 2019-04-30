package Lazarus;

import Lazarus.GameObj.*;
import Lazarus.GameObj.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
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
    private String button;
    private String wall;
    private String level1;
    private String level2;
    private String level3;
    private int maxlevel;

    //Game Element
    private int currLevel;
    private Player p1;
    private LazaKey p1Key;
    private SpwanBox spwanBox;
    private ArrayList<Wall> mapWall;
    private ArrayList<Button> levelButton;
    private Scanner scanner;
    private CardBoardBox CBox;
    private WoodBox WBox;
    private MetalBox MBox;
    private StoneBox SBox;
    private Random rng;
    private boolean firstTime;
    private ArrayList<GameObj> boxList;
    private int nextBox;

    //Draw
    private DrawPanel drawpanel;

    /**********************************************************************************************************/
    //main function

    public void LazarusWorld(){}

    public void init(){
        setResourcePath();
        this.drawpanel = new DrawPanel(fWidth,fHeight, background, this);
        currLevel = 1;
        maxlevel = 3;
        firstTime = true;
        setFrame();
        setMapObj();
        setSpwan();
        //setPlayer();
    }

    public void startGame(){
        init();
        try{
            while(true) {
                update();
                this.drawpanel.repaint();

                if(levelButton.get(0).getLevelup() || levelButton.get(1).getLevelup()){
                    if(currLevel < maxlevel){
                        levelUp();
                    }
                }

                Thread.sleep(1000/144);
            }

        } catch (InterruptedException ignored){

        }
    }

    public void stop(){}

    public void levelUp() {
        currLevel++;
    }

    public void update(){
        boxQueue();
    }

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
         button = "Resource/Button.gif";
         wall = "Resource/Wall.gif";
         level1 = "Resource/LazarusMap_Level1";
         level2 = "Resource/LazarusMap_Level2";
         level3 = "Resource/LazarusMap_Level3";
     }

     public void setFrame(){
         JFrame jFrame = new JFrame();
         jFrame.setTitle("Lazarus");
         jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jFrame.add(this.drawpanel);
         jFrame.setSize(fWidth,fHeight);

         jFrame.setVisible(true);
     }


    public void setMapObj(){
        BufferedImage img;
        String mapLevel = null;

        if(currLevel == 1){
            mapLevel = level1;
        }else if(currLevel == 2){
            mapLevel = level2;
        }else if(currLevel == 3){
            mapLevel = level3;
        }


        try {
            scanner = new Scanner(new File(mapLevel));
        }catch (IOException e){
            System.out.println("File not found");
        }

        while(scanner.hasNext()) {

            for (int row = 0; row < 12; row++) {
                String data = scanner.next();
                String[] value = data.split(",");
                for (int col = 0; col < 16; col++) {
                    int mapCode = Integer.parseInt(value[col]);
                    if (mapCode == 0) {
                        img = stringToBuffer(wall);
                        mapWall.add(new Wall(row*40, col*40, img));
                    }
                    if (mapCode == 1) {
                        img = stringToBuffer(player);
                        if(currLevel == 1){
                        p1 = new Player(row*40,col*40,img,this);
                        p1Key = new LazaKey(p1, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
                        }else if(currLevel > 1){
                            p1.setX(row*40);
                            p1.setY(col*40);
                        }
                        drawpanel.setP1(p1);
                    }
                    if (mapCode == 2) {
                        img = stringToBuffer(button);
                        levelButton.add(new Button(row*40, col*40, img));
                    }

                }
            }
        }
    }


    public void setSpwan(){
         spwanBox = new SpwanBox(this, p1);
    }

    public void boxQueue(){
        rng = new Random();
        if(firstTime) {
            for(int i = 0; i < 3; i++ ) {
                nextBox = rng.nextInt(3);
                if (nextBox + 1 == 1) {
                    CBox = new CardBoardBox(0, 0, 1,stringToBuffer(cardboardbox));
                    boxList.add(CBox);
                } else if (nextBox + 1 == 2) {
                    WBox = new WoodBox(0, 0, 2,stringToBuffer(woodbox));
                    boxList.add(WBox);
                } else if (nextBox + 1 == 3) {
                    MBox = new MetalBox(0, 0, 3,stringToBuffer(metalbox));
                    boxList.add(MBox);
                } else if (nextBox + 1 == 4) {
                    SBox = new StoneBox(0, 0, 4,stringToBuffer(stonebox));
                    boxList.add(SBox);
                }
            }
            firstTime = false;
        }else if(boxList.size() < 3){
            nextBox = rng.nextInt(3);
            if (nextBox + 1 == 1) {
                CBox = new CardBoardBox(0, 0, 1,stringToBuffer(cardboardbox));
                boxList.set(2,CBox);
            } else if (nextBox + 1 == 2) {
                WBox = new WoodBox(0, 0, 2,stringToBuffer(woodbox));
                boxList.set(2,WBox);
            } else if (nextBox + 1 == 3) {
                MBox = new MetalBox(0, 0, 3,stringToBuffer(metalbox));
                boxList.set(2,MBox);
            } else if (nextBox + 1 == 4) {
                SBox = new StoneBox(0, 0, 4,stringToBuffer(stonebox));
                boxList.set(2,SBox);
            }
        }

        this.drawpanel.setBox(boxList);
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

    public ArrayList<GameObj> getBoxList(){
        return boxList;
    }

    public BufferedImage getCBoximg(){
        return stringToBuffer(cardboardbox);
    }

    public BufferedImage getWBoximg(){
        return stringToBuffer(woodbox);
    }

    public BufferedImage getMBoximg(){
        return stringToBuffer(metalbox);
    }

    public BufferedImage getSBoximg(){
        return stringToBuffer(stonebox);
    }


}
