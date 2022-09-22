package Clases_De_Interfaz_Grafica.Edit_Playlist;

public class Controller_Edit_Playlist {
    View_Edit_Playlist view;
    Model_Edit_Playlist model;

    public Controller_Edit_Playlist(View_Edit_Playlist view, Model_Edit_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
