package Clases_De_Interfaz_Grafica.Add_Songs;


public class Controller_Add_Songs {
    View_Add_Songs view;
    Model_Add_Songs model;

    public Controller_Add_Songs(View_Add_Songs view, Model_Add_Songs model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
