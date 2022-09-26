package CE.Interfaz_Grafica.Create_Playlist;

import CE.Application;

import javax.swing.*;
import java.awt.*;

public class Controller_Create_Playlist {
    View_Create_Playlist view;
    Model_Create_Playlist model;

    public Controller_Create_Playlist(View_Create_Playlist view, Model_Create_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    static JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Crear Biblioteca Nueva", true);
        dialog.setSize(225,175);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+330,location.y+220);
        dialog.setVisible(true);
    }
    public void hide(){
        dialog.dispose();
    }
}
