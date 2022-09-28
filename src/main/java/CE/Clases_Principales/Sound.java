package CE.Clases_Principales;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Interfaz_Grafica.Songs.View_Songs;
import javax.sound.sampled.*;
import java.io.File;
import java.lang.annotation.ElementType;

public class Sound {
    public static long clipTimePosition = 0;
    public static long clipTimePosition2 = 0;
    public static javax.sound.sampled.Clip clip1 = null;
    public static javax.sound.sampled.Clip clip2 = null;
    public static int loop = 0;
    private static float currentVolume = -25f;
    static FloatControl fc1;
    static FloatControl fc2;
    private static Sound instance;
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
        int currentrow = Application.songs_controller.getView().getRow();
        //SIGUIENTE CANCIÓN
        setFile2(nextrow());
        LineListener listener1 = new LineListener() {
            public void update(LineEvent event){
                if (event.getType() == LineEvent.Type.STOP && View_Songs.reproduccion[0] == Boolean.TRUE) {
                    update(event);
                }
                if (event.getType() == LineEvent.Type.STOP && (View_Songs.reproduccion2[0] == Boolean.TRUE | View_Songs.reproduccion3[0] == Boolean.TRUE)){
                    System.out.println("DEADGE");
                    return;
                }
                if (event.getType() == LineEvent.Type.STOP){
                    if (loop == 1){
                        System.out.println("PlayMusic 2");
                        try {
                            View_Songs.playMusic1[0] = Boolean.FALSE;
                            /*Aquí se establece, en la lista de canciones, que la nueva canción seleccionada en la lista es la siguiente (La que vamos a tocar)*/
                            /*Esto para que el botón de pausar funcione con la canción actual*/
                            stopMusic();
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
        clip2.setMicrosecondPosition(clipTimePosition2);
        fc2.setValue(currentVolume);
        clip2.start();
        int currentrow = Application.songs_controller.getView().getRow();
        //SIGUIENTE CANCIÓN
        setFile2(nextrow());
        LineListener listener1 = new LineListener() {
            public void update(LineEvent event){
                if (event.getType() == LineEvent.Type.STOP && View_Songs.reproduccion[0] == Boolean.TRUE) {
                    update(event);
                }
                if (event.getType() == LineEvent.Type.STOP && (View_Songs.reproduccion2[0] == Boolean.TRUE | View_Songs.reproduccion3[0] == Boolean.TRUE)){
                    System.out.println("DEADGE");
                    return;
                }
                if (event.getType() == LineEvent.Type.STOP){
                    if (loop == 1){
                        System.out.println("PlayMusic 1");
                        try {
                            View_Songs.playMusic1[0] = Boolean.TRUE;
                            /*Aquí se establece, en la lista de canciones, que la nueva canción seleccionada en la lista es la siguiente (La que vamos a tocar)*/
                            /*Esto para que el botón de pausar funcione con la canción actual*/
                            stopMusic();
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
        clipTimePosition2 = clip2.getMicrosecondPosition();
        clip1.stop();
        clip2.stop();
    }
    public static void stopMusic(){
        clipTimePosition = 0;
        clipTimePosition2 = 0;
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
    }
    public static Sound instance(){
        if (instance == null ){
            instance = new Sound();
            clip1 = new Clip();
            clip2 = new Clip();
        }
        return instance;
    }
    public static String nextrow(){
        DoubleCircledLinkedList<Song> Lista = Application.songs_controller.getModel().getPlaylist().getSongs();
        int nextrow = Application.songs_controller.getView().getRow2();
        if (Lista.getElement(nextrow) == null){
            nextrow = 0;
            Application.songs_controller.getView().setRow2(nextrow);
            return Lista.getElement(nextrow).getMP3File();
        }
        else{
            nextrow = Application.songs_controller.getView().getRow2();
            Application.songs_controller.getView().setRow2(nextrow);
            return Lista.getElement(nextrow).getMP3File();
        }
    }
    public static String lastrow(){
        DoubleCircledLinkedList<Song> Lista = Application.songs_controller.getModel().getPlaylist().getSongs();
        int lastrow = (Application.songs_controller.getView().getRow() - 1);
        if (lastrow == - 1){
            lastrow = Application.songs_controller.getModel().getPlaylist().getSongs().getNumberOfElements() - 1;
            Application.songs_controller.getView().setRow2(lastrow);
            return Lista.getElement(lastrow).getMP3File();
        }
        else{
            lastrow = Application.songs_controller.getView().getRow() - 1;
            Application.songs_controller.getView().setRow(lastrow);
            return Lista.getElement(lastrow).getMP3File();
        }
    }
}
