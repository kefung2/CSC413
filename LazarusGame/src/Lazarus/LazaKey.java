package Lazarus;

import Lazarus.GameObj.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LazaKey implements KeyListener{

        private Player player;
        private int left, right;

        public LazaKey (Player player, int left, int right){
            this.player = player;
            this.left = left;
            this.right = right;
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
        }


}
