import Clases_De_Interfaz_Grafica.Edit_Playlist.Model_Edit_Playlist;

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
    public static Clases_De_Interfaz_Grafica.Create_Playlist.Controller_Create_Playlist create_playlist_controller;
    public static Clases_De_Interfaz_Grafica.Edit_Playlist.Controller_Edit_Playlist edit_playlist_controller;
    public static Clases_De_Interfaz_Grafica.Songs.Controller_Songs songs_controller;
    public static Clases_De_Interfaz_Grafica.Add_Songs.Controller_Add_Songs add_songs_controller;
    public static Clases_De_Interfaz_Grafica.Edit_Song.Controller_Edit_Song edit_song_controller;


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
         * Se establece el desarrollo de la ventana autenticación
         */
        Clases_De_Interfaz_Grafica.Login.Model_Login model_login = new Clases_De_Interfaz_Grafica.Login.Model_Login();
        Clases_De_Interfaz_Grafica.Login.View_Login view_login = new Clases_De_Interfaz_Grafica.Login.View_Login();
        login_controller = new Clases_De_Interfaz_Grafica.Login.Controller_Login(view_login,model_login);
        /**
        * Se establece el desarrollo de la ventana bibliotecas
        */
        Clases_De_Interfaz_Grafica.Playlist.Model_Playlist model_playlist = new Clases_De_Interfaz_Grafica.Playlist.Model_Playlist();
        Clases_De_Interfaz_Grafica.Playlist.View_Playlist view_playlist = new Clases_De_Interfaz_Grafica.Playlist.View_Playlist();
        playlist_controller = new Clases_De_Interfaz_Grafica.Playlist.Controller_Playlist(view_playlist,model_playlist);
        /**
         * Se establece el desarrollo de la ventana crear biblioteca
         */
        Clases_De_Interfaz_Grafica.Create_Playlist.Model_Create_Playlist model_create_playlist = new Clases_De_Interfaz_Grafica.Create_Playlist.Model_Create_Playlist();
        Clases_De_Interfaz_Grafica.Create_Playlist.View_Create_Playlist view_create_playlist = new Clases_De_Interfaz_Grafica.Create_Playlist.View_Create_Playlist();
        create_playlist_controller = new Clases_De_Interfaz_Grafica.Create_Playlist.Controller_Create_Playlist(view_create_playlist,model_create_playlist);
        /**
         * Se establece el desarrollo de la ventana editar biblioteca
         */
        Clases_De_Interfaz_Grafica.Edit_Playlist.Model_Edit_Playlist model_edit_playlist = new Clases_De_Interfaz_Grafica.Edit_Playlist.Model_Edit_Playlist();
        Clases_De_Interfaz_Grafica.Edit_Playlist.View_Edit_Playlist view_edit_playlist = new Clases_De_Interfaz_Grafica.Edit_Playlist.View_Edit_Playlist();
        edit_playlist_controller = new Clases_De_Interfaz_Grafica.Edit_Playlist.Controller_Edit_Playlist(view_edit_playlist,model_edit_playlist);
        /**
         * Se establece el desarrollo de la ventana songs (selección de canción por biblioteca)
         */
        Clases_De_Interfaz_Grafica.Songs.Model_Songs model_songs = new Clases_De_Interfaz_Grafica.Songs.Model_Songs();
        Clases_De_Interfaz_Grafica.Songs.View_Songs view_songs = new Clases_De_Interfaz_Grafica.Songs.View_Songs();
        songs_controller = new Clases_De_Interfaz_Grafica.Songs.Controller_Songs(view_songs,model_songs);
        /**
         * Se establece el desarrollo de la ventana añadir canciones a la biblioteca seleccionada
         */
        Clases_De_Interfaz_Grafica.Add_Songs.Model_Add_Songs model_add_songs = new Clases_De_Interfaz_Grafica.Add_Songs.Model_Add_Songs();
        Clases_De_Interfaz_Grafica.Add_Songs.View_Add_Songs view_add_songs = new Clases_De_Interfaz_Grafica.Add_Songs.View_Add_Songs();
        add_songs_controller = new Clases_De_Interfaz_Grafica.Add_Songs.Controller_Add_Songs(view_add_songs,model_add_songs);
        /**
         * Se establece el desarrollo de la ventana editar metadata de la Canción seleccionada
         */
        Clases_De_Interfaz_Grafica.Edit_Song.Model_Edit_Song model_edit_song = new Clases_De_Interfaz_Grafica.Edit_Song.Model_Edit_Song();
        Clases_De_Interfaz_Grafica.Edit_Song.View_Edit_Song view_edit_song = new Clases_De_Interfaz_Grafica.Edit_Song.View_Edit_Song();
        edit_song_controller = new Clases_De_Interfaz_Grafica.Edit_Song.Controller_Edit_Song(view_edit_song,model_edit_song);


        window = new JFrame();
        window.setSize(500,550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("CE Music Player - Adriel Chaves");
        window.setVisible(true);


        //Ventana autenticación
        //window.add(view_login.getPanel());


        //Ventana bibliotecas
        //window.add(view_playlist.getPanel());


        //Ventana crear biblioteca
        //window.add(view_create_playlist.getPanel());


        //Ventana editar biblioteca
        //window.add(view_edit_playlist.getPanel());


        //Ventana songs (selección de canción por biblioteca)
        window.add(view_songs.getPanel());


        //Ventana Añadir Canciones a la biblioteca seleccionada
        //window.add(view_add_songs.getPanel());


        //Ventana Editar Metadata de la Canción seleccionada
        //window.add(view_edit_song.getPanel());


        window.show();

        musicObject = new Clases_Principales.Sound();
    }
}