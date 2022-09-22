package Clases_De_Interfaz_Grafica.Create_Playlist;

import Clases_De_Interfaz_Grafica.Edit_Playlist.Model_Edit_Playlist;
import Clases_De_Interfaz_Grafica.Edit_Playlist.View_Edit_Playlist;

public class Controller_Create_Playlist {
    View_Create_Playlist view;
    Model_Create_Playlist model;

    public Controller_Create_Playlist(View_Create_Playlist view, Model_Create_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
