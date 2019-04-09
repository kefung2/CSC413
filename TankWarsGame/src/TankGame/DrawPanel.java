package TankGame;

import TankGame.GameObj.*;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class DrawPanel extends JPanel {

    private BufferedImage bg;
    private BufferedImage Live1, Live2;
    Image minimap;
    private int frameWidth;
    private int frameHeight;
    private int mapWidth;
    private int mapHeight;
    private int minimapWidth;
    private int minimapHeight;
    private Tank tank1, tank2;

    private ArrayList<UnBreakableWall> UBW;
    private ArrayList<BreakableWall> BW;
    private ArrayList<PowerUp> PU;
    private ArrayList<Bullet> B;


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
        BW = new ArrayList<>();
        PU = new ArrayList<>();

    }


    @Override
    public void paintComponent (Graphics g){
        getGameImage();
        super.paintComponent(g);

        g.drawImage(p1, 0, 0, this);
        g.drawImage(p2, frameWidth/2, 0, this);
        drawHUD(g);

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
        drawBullet(g2);

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

        BW.forEach((curr) -> {
            curr.draw(g);
        });

        PU.forEach((curr) -> {
            curr.draw(g);
        });
    }

    private void drawBullet(Graphics2D g){
        Graphics2D g2 = (Graphics2D) g;

        try{
            B.forEach((curr) -> {
                if(curr.isVisible()){
                curr.draw(this,g2);
                }
            });
        } catch (ConcurrentModificationException e){
        }
    }

    public void drawBG(Graphics2D g2){
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 8; j++)
                g2.drawImage(bg, bg.getWidth()*i, bg.getHeight()*j, this);
        }
    }

    public void drawHUD(Graphics g){
        int p1_hp = this.tank1.getHealth() * 2;
        int p2_hp = this.tank2.getHealth() * 2;

        int p1_lives = this.tank1.getLifes();
        int p2_lives = this.tank2.getLifes();

        int p1_hp_x = 22;
        int p1_hp_y = 758;

        int p2_hp_x = 578;
        int p2_hp_y = 758;

        int hp_w = 200;
        int hp_h = 20;

        int offset = 4;
        int sizeOffect = 8;

        //HP
        g.setColor(Color.DARK_GRAY);
        g.fillRect(p1_hp_x, p1_hp_y, hp_w, hp_h); //p1
        g.fillRect(p2_hp_x, p2_hp_y, hp_w, hp_h); //p2

        //HP lose
        g.setColor(Color.RED);
        g.fillRect(p1_hp_x + offset, p1_hp_y + offset, hp_w - sizeOffect, hp_h - sizeOffect);
        g.fillRect(p2_hp_x + offset, p2_hp_y + offset, hp_w - sizeOffect, hp_h - sizeOffect);

        //HP left
        g.setColor(Color.GREEN);
        g.fillRect(p1_hp_x + offset, p1_hp_y + offset, hp_w - sizeOffect, hp_h - sizeOffect);
        g.fillRect(p2_hp_x + (hp_w - p2_hp) + offset, p2_hp_y + offset, p2_hp - sizeOffect, hp_h - sizeOffect);

        //P1 lives
        int p1_life_x = 110;
        int p1_life_y = 730;
        int p1_Loffset = 40;
        for(int i = 0; i < p1_lives; i++){
            g.drawImage(Live1 , p1_life_x + (i*p1_Loffset), p1_life_y, this);
        }

        //P2 lives
        int p2_life_x = 690;
        int p2_life_y = 730;
        int p2_Loffset = 40;
        for(int i = 0; i < p2_lives; i++){
            g.drawImage(Live2 , p2_life_x - (i*p2_Loffset), p2_life_y, this);
        }
    }



/******************************************************************************************/
    public void setTank(Tank tank1, Tank tank2){
        this.tank1 = tank1;
        this.tank2 = tank2;
    }

    public void setMapObj(ArrayList<UnBreakableWall> UBW, ArrayList<BreakableWall> BW, ArrayList<PowerUp> PU){
        this.UBW = UBW;
        this.BW = BW;
        this.PU = PU;
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

    public void setBullet(ArrayList<Bullet> b){
        this.B = b;
    }

    public void setLiveIcon (BufferedImage p1L, BufferedImage p2L){
        this.Live1 = p1L;
        this.Live2 = p2L;
    }

    /*****************************************************************************************************************/

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
