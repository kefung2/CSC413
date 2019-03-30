package TankGame;

import TankGame.GameObj.Tank;
import TankGame.GameObj.UnBreakableWall;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private BufferedImage bg;
    Image minimap;
    private int frameWidth;
    private int frameHeight;
    private int mapWidth;
    private int mapHeight;
    private int minimapWidth;
    private int minimapHeight;
    private Tank tank1, tank2;

    private ArrayList<UnBreakableWall> UBW;

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
        minimapWidth = 200;
        minimapHeight = 200;

        setSize(mapWidth,mapHeight);
        //setPreferredSize(new Dimension(fWidth,fHeight));
        this.bg = setImage(imgPath);

        UBW = new ArrayList<>();

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

        g.drawImage(minimap, (frameWidth/2)-(minimapWidth/2), 580, this);
        g.draw3DRect((frameWidth/2)-(minimapWidth/2), 580, minimapWidth, minimapHeight, true);

    }

    public void getGameImage(){
        BufferedImage bimg = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bimg.createGraphics();

        drawBG(g2);
        drawMapObj(g2);
        drawTank(g2);


        playerViewBoundChecker();
        p1 = bimg.getSubimage(this.p1X, this.p1Y,frameWidth/2, frameHeight);
        p2 = bimg.getSubimage(this.p2X, this.p2Y,frameWidth/2, frameHeight);
        minimap = bimg.getScaledInstance(minimapWidth,minimapHeight, Image.SCALE_SMOOTH);

    }

/*************************************************************************************/
    public void drawTank(Graphics2D g){
        Graphics2D gt = (Graphics2D) g;

        this.tank1.draw(gt);
        this.tank2.draw(gt);
    }

    private void drawMapObj(Graphics2D g){
        UBW.forEach((curr) -> {
            curr.draw(g);
        });
    }

    public void drawBG(Graphics2D g2){
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 8; j++)
                g2.drawImage(bg, bg.getWidth()*i, bg.getHeight()*j, this);
        }
    }



/******************************************************************************************/
    public void setTank(Tank tank1, Tank tank2){
        this.tank1 = tank1;
        this.tank2 = tank2;
    }

    public void setMapObj(ArrayList<UnBreakableWall> UBW){
        this.UBW = UBW;
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

    //CREDIT
    private void playerViewBoundChecker() {
        if ((this.p1X = tank1.getTankCenterX() - frameWidth / 4) < 0) {
            this.p1X = 0;
        } else if (this.p1X >= mapWidth - frameWidth / 2) {
            this.p1X = (mapWidth - frameWidth / 2);
        }

        if ((this.p1Y = tank1.getTankCenterY() - frameHeight / 2) < 0) {
            this.p1Y = 0;
        } else if (this.p1Y >= mapHeight - frameHeight) {
            this.p1Y = (mapHeight - frameHeight);
        }

        if ((this.p2X = tank2.getTankCenterX() - frameWidth / 4) < 0) {
            this.p2X = 0;
        } else if (this.p2X >= mapWidth - frameWidth / 2) {
            this.p2X = (mapWidth - frameWidth / 2);
        }

        if ((this.p2Y = tank2.getTankCenterY() - frameHeight / 2) < 0) {
            this.p2Y = 0;
        } else if (this.p2Y >= mapHeight - frameHeight) {
            this.p2Y = (mapHeight - frameHeight);
        }
    }

}
