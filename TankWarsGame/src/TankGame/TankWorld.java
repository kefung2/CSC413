package TankGame;

import TankGame.GameObj.Tank;
import TankGame.GameObj.UnBreakableWall;
import TankGame.TankKey;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TankWorld extends JComponent {

    //JFrame
    private String Title = "Tank Warz";
    private int frameWidth = 800;
    private int frameHeight = 822;
    private int mapWidth = 1600; //1024
    private int mapHeigth = 1600; //768

    //resource
    private String bg;
    private String bgm;
    private String walls;
    private String bwalls;
    private String p1tank;
    private String p2tank;
    private String powerUp;

    //Map
    private int[][] mapLayout;
    private ArrayList<UnBreakableWall> UBW;

    //Draw
    private DrawPanel drawPanel;

    //
    private static Tank p1, p2;
    private TankKey p1Key, p2Key;

/******************************************************************************************/
    public void TankWorld(){
        //setMap();
    }

    public void init(){
        setUpResourcePath();
        this.drawPanel = new DrawPanel(mapWidth,mapHeigth,frameWidth,frameHeight,bg);

        playerSetup();
        setMap();
        setMapObj();

        setFrame();
        //playerSetup();

    }


    public void setUpResourcePath(){
        bg = "Resource/Background.bmp";
        bgm = "Resource/Music.mp3";
        walls = "Resource/Wall1.gif";
        bwalls = "Resource/Wall2.gif";
        p1tank = "Resource/Tank1.gif";
        p2tank = "Resource/Tank2.gif";
        powerUp = "Resource/Pickup.gif";

    }



    // 0 = empty, 1 = unbreakable walls, 2 = breakable walls, 3 = p1 spawn, 4 = p2 spawn, 5 = power up
    public void setMap(){
        mapLayout = new int[][]{
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,5,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }

    public void setMapObj(){
        UBW = new ArrayList<>();
        BufferedImage img;
        int cellSize = 64;
        int extra = 32;

        for(int row = 0; row < 25; row++){
            for(int col = 0; col < 25; col++){
                if(this.mapLayout[row][col] == 1){
                    img = stringToBuffer(walls);
                    UBW.add(new UnBreakableWall(col*cellSize, row*cellSize, img.getWidth(), img.getHeight(),img));
                    UBW.add(new UnBreakableWall((col*cellSize)+extra, row*cellSize,img.getWidth(), img.getHeight(),img));
                    UBW.add(new UnBreakableWall(col*cellSize, (row*cellSize)+extra,img.getWidth(), img.getHeight(),img));
                    UBW.add(new UnBreakableWall((col*cellSize)+extra, (row*cellSize)+extra,img.getWidth(), img.getHeight(),img));
                }
                if(mapLayout[row][col] == 2){
                }
                if(mapLayout[row][col] == 3){
                }
                if(mapLayout[row][col] == 4){
                }
                if(mapLayout[row][col] == 5){
                }
            }
        }

        this.drawPanel.setMapObj(this.UBW);
    }

    public void setFrame (){
        JFrame frame = new JFrame();
        frame.setTitle(Title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane();
        frame.add(this.drawPanel);
        frame.setSize(frameWidth,frameHeight);

        frame.setResizable(false);
        //frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(p1Key);
        frame.addKeyListener(p2Key);

        frame.setVisible(true);
    }

    public void renderBG(){

    }

    public void playerSetup(){
        BufferedImage p1tankImg = stringToBuffer(p1tank);
        BufferedImage p2tankImg = stringToBuffer(p2tank);

        p1 = new Tank(this, p1tankImg, 100,100, 2/**, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER*/);
        p2 = new Tank(this, p2tankImg, 1400,1400, 2/**, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_T*/);

        p1Key = new TankKey(p1, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_T);
        p2Key = new TankKey(p2, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER);

        p1.setOtherTank(p2);
        p2.setOtherTank(p1);

        this.drawPanel.setTank(p1, p2);
    }

    public void startGame(){
        init();
        try {
            while(true) {
                this.p1.update();
                this.p2.update();
                this.drawPanel.repaint();
                Thread.sleep(1000/144);
            }
        } catch (InterruptedException ignored) {

        }
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

    public static Tank getTank(int i){
        switch (i){
            case 1:
                return p1;
                //break;
            case 2:
                return p2;
                //break;
            default:
                return null;

        }
    }

}
