package CE.Interfaz_Grafica.Songs;

import CE.Application;

public class Controller_Songs {
    View_Songs view;
    Model_Songs model;

    public Controller_Songs(View_Songs view, Model_Songs model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void add_song(){
        Application.add_songs_controller.show();
    }

    public void edit_song(){
        Application.edit_song_controller.show();
    }
}
