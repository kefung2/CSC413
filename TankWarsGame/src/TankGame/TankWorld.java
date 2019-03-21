package TankGame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TankWorld extends JComponent {

    //JFrame
    private String Title = "Tank Warz";
    private int frameWidth = 800;
    private int frameHeight = 822;
    private int mapWidth = 1600;
    private int mapHeigth = 1600;

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

    //Draw
    private DrawPanel drawPanel;

/******************************************************************************************/
    public void TankWorld(){
        //setMap();
    }

    public void init(){
        setUpResourcePath();
        this.drawPanel = new DrawPanel(mapWidth,mapHeigth,frameWidth,frameHeight,bg);

        setFrame();

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
                {1,1,1,1,1},
                {1,3,0,5,1},
                {1,0,2,0,1},
                {1,0,0,4,1},
                {1,1,1,1,1},
        };

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(mapLayout[row][col] == 1){
                    Image image = Toolkit.getDefaultToolkit().getImage(walls);
                }else if(mapLayout[row][col] == 2){
                    Image image = Toolkit.getDefaultToolkit().getImage(bwalls);
                }else if(mapLayout[row][col] == 3){
                    Image image = Toolkit.getDefaultToolkit().getImage(p1tank);
                }else if(mapLayout[row][col] == 4){
                    Image image = Toolkit.getDefaultToolkit().getImage(p2tank);
                }else if(mapLayout[row][col] == 5){
                    Image image = Toolkit.getDefaultToolkit().getImage(powerUp);
                }
            }
        }
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

        frame.setVisible(true);
    }
    public void renderBG(){

    }

    public void playerSetup(){

    }

    public void startGame(){
        init();
    }



}
