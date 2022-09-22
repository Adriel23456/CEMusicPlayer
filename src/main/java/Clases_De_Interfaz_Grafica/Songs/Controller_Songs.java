package Clases_De_Interfaz_Grafica.Songs;

public class Controller_Songs {
    View_Songs view;
    Model_Songs model;

    public Controller_Songs(View_Songs view, Model_Songs model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
