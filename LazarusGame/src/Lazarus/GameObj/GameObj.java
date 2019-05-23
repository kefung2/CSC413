package Lazarus.GameObj;

import java.awt.*;

public interface GameObj  {

    boolean collision(Rectangle rect);
    void draw(Graphics2D g);

}
