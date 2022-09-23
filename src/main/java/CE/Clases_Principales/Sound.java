package CE.Clases_Principales;

import CE.Interfaz_Grafica.Songs.View_Songs;
import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Sound {
    public static long clipTimePosition = 0;
    public static javax.sound.sampled.Clip clip1 = null;
    public static javax.sound.sampled.Clip clip2 = null;
    public static int loop = 0;
    private static float currentVolume = -25f;
    static FloatControl fc1;
    static FloatControl fc2;
    public static void setFile(String musiclocation){
        try{
            File musicPath = new File(musiclocation);
            if (musicPath.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(musicPath);
                clip1 = AudioSystem.getClip();
                clip1.open(sound);
                fc1 = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
            }
        }
        catch(Exception e){
        }
    }
    public static void setFile2(String musiclocation){
        try{
            File musicPath = new File(musiclocation);
            if (musicPath.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(musicPath);
                clip2 = AudioSystem.getClip();
                clip2.open(sound);
                fc2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
            }
        }
        catch(Exception e){
        }
    }
    public static void playMusic() throws InterruptedException {
        clip1.setMicrosecondPosition(clipTimePosition);
        fc1.setValue(currentVolume);
        clip1.start();
        LineListener listener1 = new LineListener() {
            public void update(LineEvent event){
                if (event.getType() == LineEvent.Type.STOP && View_Songs.reproduccion[0] == Boolean.TRUE) {
                    update(event);
                }
                if (event.getType() == LineEvent.Type.STOP && (View_Songs.reproduccion2[0] == Boolean.TRUE)){
                    /*| SI SE PRESIONA DOS VECES REPRODUCCIÓN OCUPO ASEGURARME DE MATAR EL PRIMER REPRODUCCION CUANDO SE CLICKÉ POR 2DA VES*/
                    return;
                }
                if (event.getType() == LineEvent.Type.STOP){
                    if (loop == 1){
                        System.out.println("FUNCIONAL");
                        setFile2("Canciones/MIRÁ MAMÁ.wav"/*GET DE LA CANCIÓN QUE LE SIGUE A SETFILE 2*/);
                        try {
                            playMusic2();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else {
                    return;
                }
            }
        };
        clip1.addLineListener(listener1);
    }
    public static void playMusic2() throws InterruptedException {
        clip2.setMicrosecondPosition(clipTimePosition);
        fc2.setValue(currentVolume);
        clip2.start();
        LineListener listener1 = new LineListener() {
            public void update(LineEvent event){
                if (event.getType() == LineEvent.Type.STOP && View_Songs.reproduccion[0] == Boolean.TRUE) {
                    update(event);
                }
                if (event.getType() == LineEvent.Type.STOP && (View_Songs.reproduccion2[0] == Boolean.TRUE)
                    /*| SI SE PRESIONA DOS VECES REPRODUCCIÓN OCUPO ASEGURARME DE MATAR EL PRIMER REPRODUCCION CUANDO SE CLICKÉ POR 2DA VES*/){
                    return;
                }
                if (event.getType() == LineEvent.Type.STOP){
                    if (loop == 1){
                        System.out.println("FUNCIONAL");
                        setFile("Canciones/MIRÁ MAMÁ.wav"/*GET DE LA CANCIÓN QUE LE SIGUE A SETFILE 2*/);
                        try {
                            playMusic();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else {
                    return;
                }
            }
        };
        clip2.addLineListener(listener1);
    }
    public static void pauseMusic(){
        clipTimePosition = clip1.getMicrosecondPosition();
        clip1.stop();
        clip2.stop();
    }
    public static void stopMusic(){
        clipTimePosition = 0;
        clip1.stop();
        clip2.stop();
    }
    public static void loopMusic(){
        System.out.println("LOOPMUSIC");
        loop = 1;
    }
    public static void NOloopMusic(){
        System.out.println("NOLOOPMUSIC");
        loop = 0;
    }
    public static void volumeUp(){
        currentVolume = currentVolume + 1.0f;
        System.out.println("Current Volume: "+currentVolume);
        if (currentVolume > 1.0f){
            currentVolume = 1.0f;
        }
        fc1.setValue(currentVolume);
        fc2.setValue(currentVolume);
    }
    public static void volumeDown(){
        currentVolume = currentVolume - 1.0f;
        System.out.println("Current Volume: "+currentVolume);
        if (currentVolume < -80.0f){
            currentVolume = -80.0f;
        }
        fc1.setValue(currentVolume);
        fc2.setValue(currentVolume);
    }
    private static Sound instance;

    public static Sound instance(){
        if (instance == null ){
            instance = new Sound();
            clip1 = new Clip();
            clip2 = new Clip();
        }
        return instance;
    }
}
