package Lazarus.GameObj;

import Lazarus.GameObj.CardBoardBox;
import Lazarus.GameObj.WoodBox;
import Lazarus.GameObj.MetalBox;
import Lazarus.GameObj.StoneBox;
import Lazarus.LazarusWorld;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpwanBox{

    private LazarusWorld world;
    private Player p1;
    private CardBoardBox CBox;
    private WoodBox WBox;
    private MetalBox MBox;
    private StoneBox SBox;
    private GameObj nextBox;
    private Rectangle nextBoxRect;
    private boolean boxDropping;

    /******************************************************************************************************************/
/*
    public SpwanBox(){}

    public SpwanBox(LazarusWorld world, Player p1){
        this.world = world;
        this.p1 = p1;
        boxDropping = false;

    }

    @Override
    public boolean collision(Rectangle rect) {
        return false;
    }

    @Override
    public void draw(Graphics2D g) {
        if(!boxDropping){
            nextBox = world.getBoxList().get(0);
            if(nextBox instanceof CardBoardBox){
                nextBox = (CardBoardBox) nextBox;
                ((CardBoardBox) nextBox).setX(p1.getX());
                nextBoxRect = ((CardBoardBox) nextBox).getRect();
            }else if(nextBox instanceof WoodBox){
                nextBox = (WoodBox) nextBox;
                ((WoodBox) nextBox).setX(p1.getX());
                nextBoxRect = ((CardBoardBox) nextBox).getRect();
            }else if(nextBox instanceof MetalBox){
                nextBox = (MetalBox) nextBox;
                ((MetalBox) nextBox).setX(p1.getX());
                nextBoxRect = ((CardBoardBox) nextBox).getRect();
            }else if(nextBox instanceof StoneBox){
                nextBox = (StoneBox) nextBox;
                ((StoneBox) nextBox).setX(p1.getX());
                nextBoxRect = ((CardBoardBox) nextBox).getRect();
            }
            nextBox.draw(g);
            world.getBoxList().remove(0);
            world.getBoxList().set(0,world.getBoxList().get(1));
            world.getBoxList().set(1,world.getBoxList().get(2));
            world.getBoxList().remove(2);

            if(collision(nextBoxRect)){

            }


        }
    }*/

}

