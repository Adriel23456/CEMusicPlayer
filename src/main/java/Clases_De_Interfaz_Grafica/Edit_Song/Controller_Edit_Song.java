package Clases_De_Interfaz_Grafica.Edit_Song;

public class Controller_Edit_Song {
    View_Edit_Song view;
    Model_Edit_Song model;

    public Controller_Edit_Song(View_Edit_Song view, Model_Edit_Song model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
