package Clases_Principales;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    static String musiclocation;
    static long clipTimePosition = 0;
    static javax.sound.sampled.Clip clip;
    public static void playMusic(String musicLocation){
        try{
            File musicPath = new File(musicLocation);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();
            }else {
                System.out.println("Can't find file");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void pauseMusic(){
        try{
            clipTimePosition = clip.getMicrosecondPosition();
            clip.stop();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    private static Sound instance;

    public static Sound instance(){
        if (instance == null ){
            instance = new Sound();
            clip = new Clip();
        }
        return instance;
    }
}
