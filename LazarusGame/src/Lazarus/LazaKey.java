package Lazarus;

import Lazarus.GameObj.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LazaKey implements KeyListener{

        private Player player;
        private int left, right, up, down;

        public LazaKey (Player player, int left, int right/*, int up, int down*/){
            this.player = player;
            this.left = left;
            this.right = right;
//            this.up = up;
//            this.down = down;
        }

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            int keyPressed = ke.getKeyCode();
            if (keyPressed == left) {
                this.player.toggleGoLeft();
            }
            if (keyPressed == right) {
                this.player.toggleGoRight();
            }
//            if (keyPressed == up) {
//                this.player.toggleGoUp();
//            }
//            if (keyPressed == down) {
//                this.player.toggleGoDown();
//            }


        }

        @Override
        public void keyReleased(KeyEvent ke) {
            int keyReleased = ke.getKeyCode();
            if (keyReleased  == left) {
                this.player.UntoggleGoLeft();
            }
            if (keyReleased  == right) {
                this.player.UntoggleGoRight();
            }
//            if (keyReleased  == up) {
//                this.player.UntoggleGoUp();
//            }
//            if (keyReleased == down) {
//                this.player.UntoggleGoDown();
//            }
        }


}
