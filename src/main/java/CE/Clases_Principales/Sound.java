package CE.Clases_Principales;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {
    public static long clipTimePosition = 0;
    public static javax.sound.sampled.Clip clip = null;
    public static int loop = 0;
    private static float currentVolume = -25f;
    static FloatControl fc;

    public static void setFile(String musiclocation){
        try{
            File musicPath = new File(musiclocation);
            if (musicPath.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(sound);
                fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
        }
        catch(Exception e){
        }
    }
    public static void playMusic(){
        clip.setMicrosecondPosition(clipTimePosition);
        fc.setValue(currentVolume);
        clip.start();
    }
    public static void pauseMusic(){
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }
    public static void stopMusic(){
        clipTimePosition = 0;
        clip.stop();
    }
    public static void loopMusic(){
        loop = 1;
    }
    public static void NOloopMusic(){
        loop = 0;
    }
    public static void volumeUp(){
        currentVolume = currentVolume + 1.0f;
        System.out.println("Current Volume: "+currentVolume);
        if (currentVolume > 1.0f){
            currentVolume = 1.0f;
        }
        fc.setValue(currentVolume);
    }
    public static void volumeDown(){
        currentVolume = currentVolume - 1.0f;
        System.out.println("Current Volume: "+currentVolume);
        if (currentVolume < -80.0f){
            currentVolume = -80.0f;
        }
        fc.setValue(currentVolume);
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
