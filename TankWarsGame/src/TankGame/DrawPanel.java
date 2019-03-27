package TankGame;

import TankGame.GameObj.Tank;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel {

    private BufferedImage bg;
    private int frameWidth;
    private int frameHeight;
    private int mapWidth;
    private int mapHeight;
    private int minimapWidht;
    private int minimapHeight;
    private Tank tank1, tank2;

    BufferedImage p1, p2;

    private int p1X, p1Y, p2X, p2Y;

/*****************************************************************************************************************/

    public DrawPanel(){}

    public DrawPanel(int mWidth, int mHeight, int fWidth, int fHeight, String imgPath){
        super();
        frameHeight = fHeight;
        frameWidth = fWidth;
        mapHeight = mHeight;
        mapWidth = mWidth;
        setSize(mapWidth,mapHeight);
        //setPreferredSize(new Dimension(fWidth,fHeight));
        this.bg = setImage(imgPath);

    }


    @Override
    public void paintComponent (Graphics g){
        getGameImage();
        super.paintComponent(g);

        g.drawImage(p1, 0, 0, this);
        g.drawImage(p2, frameWidth/2, 0, this);

        g.setColor(Color.BLACK);
        g.draw3DRect(0,0,(frameWidth/2)-1,frameHeight-22,true);
        g.draw3DRect(frameWidth/2, 0, (frameWidth/2)-1, frameHeight-2, true);

    }


    public void drawBG(Graphics2D g2){
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 8; j++)
                g2.drawImage(bg, bg.getWidth(), bg.getHeight(), this);
        }
    }

    public void drawTank(Graphics2D g){
        Graphics2D gt = (Graphics2D) g;

        this.tank1.draw(gt);
        this.tank2.draw(gt);
    }


    public void getGameImage(){
        BufferedImage bimg = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bimg.createGraphics();

        drawBG(g2);
        drawTank(g2);
        drawTank(g2);

        p1 = bimg.getSubimage(p1X, p1Y,frameWidth/2, frameHeight);
        p2 = bimg.getSubimage(p2X, p2Y,frameWidth, frameHeight);

    }

    public BufferedImage setImage(String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Fail to get image from " + path + " in DrawPanel.java");
        }

        return img;
    }

    public void setTank(Tank tank1, Tank tank2){
        this.tank1 = tank1;
        this.tank2 = tank2;
    }


}
