package Clases_De_Interfaz_Grafica.Playlist;

import Clases_De_Interfaz_Grafica.Login.Model_Login;
import Clases_De_Interfaz_Grafica.Login.View_Login;

public class Controller_Playlist {

    View_Playlist view;
    Model_Playlist model;

    public Controller_Playlist(View_Playlist view, Model_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
