package TankGame;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sound {
    private AudioInputStream soundS;
    private Clip clip;
    private int type;

    public Sound(int type, String sound){
        this.type = type;
        try{
            soundS = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(sound));
            clip = AudioSystem.getClip();
            clip.open(soundS);
        } catch (Exception e){
            System.out.println("No sound for you");
        }
        if(this.type == 1){
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    while(true){
                        clip.start();
                        clip.loop(clip.LOOP_CONTINUOUSLY);
                        try{
                            Thread.sleep(10000);
                        }catch (InterruptedException ex){
                            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            Thread thread = new Thread(run);
            thread.start();
        }
    }
}
