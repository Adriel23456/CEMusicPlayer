import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author Adriel
 */
public class Application {
    /**
     * Se establecen los atributos de los controllers de todas las ventanas, fuera del método main para llamarlos en cualquier situación
     */
    public static JFrame window;
    public static Clases_De_Interfaz_Grafica.Login.Controller_Login login_controller;
    public static Clases_De_Interfaz_Grafica.Playlist.Controller_Playlist playlist_controller;
    public static Clases_Principales.Sound musicObject;

    static Scanner scanner = new Scanner(System.in);   //Scanner object to read user input
    InputStream input;

    /**
     * Se establece la clase main, la cual inicia el programa con la iniciación de la ventana Login
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, LineUnavailableException {

        /**
         * Se establece el desarrollo de la primera ventana del programa
         */
        Clases_De_Interfaz_Grafica.Login.Model_Login model_login = new Clases_De_Interfaz_Grafica.Login.Model_Login();
        Clases_De_Interfaz_Grafica.Login.View_Login view_login = new Clases_De_Interfaz_Grafica.Login.View_Login();
        login_controller = new Clases_De_Interfaz_Grafica.Login.Controller_Login(view_login,model_login);

        Clases_De_Interfaz_Grafica.Playlist.Model_Playlist model_playlist = new Clases_De_Interfaz_Grafica.Playlist.Model_Playlist();
        Clases_De_Interfaz_Grafica.Playlist.View_Playlist view_playlist = new Clases_De_Interfaz_Grafica.Playlist.View_Playlist();
        playlist_controller = new Clases_De_Interfaz_Grafica.Playlist.Controller_Playlist(view_playlist,model_playlist);


        window = new JFrame();
        window.setSize(500,550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("CE Music Player - Adriel Chaves");
        window.setVisible(true);
        //window.add(view_login.getPanel());
        window.add(view_playlist.getPanel());
        window.show();

        musicObject = new Clases_Principales.Sound();
    }
}