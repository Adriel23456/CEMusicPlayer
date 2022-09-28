package CE;
import CE.Clases_Principales.CEMusicPlayer;
import CE.Clases_Principales.Service;
import CE.Interfaz_Grafica.Add_Songs.Controller_Add_Songs;
import CE.Interfaz_Grafica.Add_Songs.Model_Add_Songs;
import CE.Interfaz_Grafica.Add_Songs.View_Add_Songs;
import CE.Interfaz_Grafica.Create_Playlist.Controller_Create_Playlist;
import CE.Interfaz_Grafica.Create_Playlist.Model_Create_Playlist;
import CE.Interfaz_Grafica.Create_Playlist.View_Create_Playlist;
import CE.Interfaz_Grafica.Edit_Playlist.Controller_Edit_Playlist;
import CE.Interfaz_Grafica.Edit_Playlist.View_Edit_Playlist;
import CE.Interfaz_Grafica.Edit_Playlist.Model_Edit_Playlist;
import CE.Interfaz_Grafica.Edit_Song.Controller_Edit_Song;
import CE.Interfaz_Grafica.Edit_Song.Model_Edit_Song;
import CE.Interfaz_Grafica.Edit_Song.View_Edit_Song;
import CE.Interfaz_Grafica.Login.Controller_Login;
import CE.Interfaz_Grafica.Login.Model_Login;
import CE.Interfaz_Grafica.Login.View_Login;
import CE.Interfaz_Grafica.Playlist.Controller_Playlist;
import CE.Interfaz_Grafica.Playlist.Model_Playlist;
import CE.Interfaz_Grafica.Playlist.View_Playlist;
import CE.Interfaz_Grafica.Songs.Controller_Songs;
import CE.Interfaz_Grafica.Songs.Model_Songs;
import CE.Interfaz_Grafica.Songs.View_Songs;
import CE.Clases_Principales.Sound;
import CE.Interfaz_Grafica.Tabbedpane.Controller_Tabbedpane;
import CE.Interfaz_Grafica.Tabbedpane.Model_Tabbedpane;
import CE.Interfaz_Grafica.Tabbedpane.View_Tabbedpane;

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
    public static Controller_Login login_controller;
    public static Controller_Playlist playlist_controller;
    public static Controller_Create_Playlist create_playlist_controller;
    public static Controller_Edit_Playlist edit_playlist_controller;
    public static Controller_Songs songs_controller;
    public static Controller_Add_Songs add_songs_controller;
    public static Controller_Edit_Song edit_song_controller;
    public static Controller_Tabbedpane mainController;
    public static Sound musicObject;

    static Scanner scanner = new Scanner(System.in);   //Scanner object to read user input
    InputStream input;

    /**
     * Se establece la clase main, la cual inicia el programa con la iniciación de la ventana Login
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, LineUnavailableException {

        CEMusicPlayer.instance().setSongs(Service.instance().loadSongs());

        window = new JFrame();
        window.setSize(850,600);
        window.setLocation(500,140);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("CE Music Player - Adriel Chaves");

        /**
         * Se establece el desarrollo de la ventana autenticación
         */
        Model_Login model_login = new Model_Login();
        View_Login view_login = new View_Login();
        login_controller = new Controller_Login(view_login,model_login);
        /**
        * Se establece el desarrollo de la ventana bibliotecas
        */
        Model_Playlist model_playlist = new Model_Playlist();
        View_Playlist view_playlist = new View_Playlist();
        playlist_controller = new Controller_Playlist(view_playlist, model_playlist, edit_playlist_controller, create_playlist_controller);
        /**
         * Se establece el desarrollo de la ventana crear biblioteca
         */
        Model_Create_Playlist model_create_playlist = new Model_Create_Playlist();
        View_Create_Playlist view_create_playlist = new View_Create_Playlist();
        create_playlist_controller = new Controller_Create_Playlist(view_create_playlist,model_create_playlist);
        /**
         * Se establece el desarrollo de la ventana editar biblioteca
         */
        Model_Edit_Playlist model_edit_playlist = new Model_Edit_Playlist();
        View_Edit_Playlist view_edit_playlist = new View_Edit_Playlist();
        edit_playlist_controller = new Controller_Edit_Playlist(view_edit_playlist,model_edit_playlist);
        /**
         * Se establece el desarrollo de la ventana songs (selección de canción por biblioteca)
         */
        Model_Songs model_songs = new Model_Songs();
        View_Songs view_songs = new View_Songs();
        songs_controller = new Controller_Songs(view_songs,model_songs, edit_song_controller, add_songs_controller);
        /**
         * Se establece el desarrollo de la ventana añadir canciones a la biblioteca seleccionada
         */
        Model_Add_Songs model_add_songs = new Model_Add_Songs();
        View_Add_Songs view_add_songs = new View_Add_Songs();
        add_songs_controller = new Controller_Add_Songs(view_add_songs,model_add_songs);
        /**
         * Se establece el desarrollo de la ventana editar metadata de la Canción seleccionada
         */
        Model_Edit_Song model_edit_song = new Model_Edit_Song();
        View_Edit_Song view_edit_song = new View_Edit_Song();
        edit_song_controller = new Controller_Edit_Song(view_edit_song,model_edit_song);
        /**
        * Se establece el desarrollo de la ventana Tabbed-pane
        */
        Model_Tabbedpane mainModel  = new Model_Tabbedpane();
        View_Tabbedpane mainView = new View_Tabbedpane();
        mainController = new Controller_Tabbedpane(mainView, mainModel);

        mainView.getTabbedPane().add("Bibliotecas", view_playlist.getPanel());
        mainView.getTabbedPane().add("Canciones",view_songs.getPanel());

        window.setVisible(true);
        mainController.show();
        Application.playlist_controller.getView().Log_out();

        musicObject = new Sound();
    }
}