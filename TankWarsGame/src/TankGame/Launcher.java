package TankGame;

import javax.swing.*;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args){
        //System.out.println("test 2");
        //TankWorld.run();
        TankWorld tankWorld = new TankWorld();
        /**
         * JFrame frame = new JFrame();
         * frame.setTitle("Tank Warz");
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.getContentPane();
         * frame.add(tankWorld);
         * frame.setBounds(50,50,1024,768);
         * frame.setVisible(true);
         * frame.setResizable(true);
         * frame.setLocationByPlatform(true);
         * frame.setLocationRelativeTo(null);
         *
         */
        tankWorld.startGame();
    }
}