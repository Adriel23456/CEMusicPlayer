package CE.Interfaz_Grafica.Playlist;

import CE.Application;
import CE.Interfaz_Grafica.Login.Model_Login;
import CE.Interfaz_Grafica.Login.View_Login;

import javax.swing.*;
import java.awt.*;

public class Controller_Playlist {

    View_Playlist view;
    Model_Playlist model;

    /**
     * Se establece el desarrollo de la ventana autenticación
     */
    View_Login view_login = new View_Login();

    public Controller_Playlist(View_Playlist view, Model_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void log_out(){
        Application.login_controller.show();
    }
    public void create_playlist(){
        Application.create_playlist_controller.show();
    }

    public void edit_playlist(){
        Application.edit_playlist_controller.show();
    }

    public View_Playlist getView() {
        return view;
    }
    public Model_Playlist getModel() {
        return model;
    }
}
