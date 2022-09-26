package CE.Interfaz_Grafica.Add_Songs;


import CE.Application;

import javax.swing.*;
import java.awt.*;

public class Controller_Add_Songs {
    View_Add_Songs view;
    Model_Add_Songs model;

    public Controller_Add_Songs(View_Add_Songs view, Model_Add_Songs model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    static JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Crear Biblioteca Nueva", true);
        dialog.setSize(475,450);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+200,location.y+80);
        dialog.setVisible(true);
    }
    public void hide(){
        dialog.dispose();
    }
}
