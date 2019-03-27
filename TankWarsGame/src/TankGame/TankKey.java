package TankGame;

import TankGame.GameObj.Tank;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class TankKey implements KeyListener{

    private Tank player;
    private final int up;
    private final int down;
    private final int right;
    private final int left;
    private final int shoot;

    public TankKey (Tank player, int up, int down, int left, int right, int shoot){
        this.player = player;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.shoot = shoot;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            this.player.toggleGoUp();
        }
        if (keyPressed == down) {
            this.player.toggleGoDown();
        }
        if (keyPressed == left) {
            this.player.toggleGoLeft();
        }
        if (keyPressed == right) {
            this.player.toggleGoRight();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased  == up) {
            this.player.UntoggleGoUp();
        }
        if (keyReleased == down) {
            this.player.UntoggleGoDown();
        }
        if (keyReleased  == left) {
            this.player.UntoggleGoLeft();
        }
        if (keyReleased  == right) {
            this.player.UntoggleGoRight();
        }

    }
}
