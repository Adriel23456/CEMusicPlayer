package CE.Interfaz_Grafica.Edit_Playlist;

import CE.Application;

import javax.swing.*;
import java.awt.*;

public class Controller_Edit_Playlist {
    View_Edit_Playlist view;
    Model_Edit_Playlist model;

    public Controller_Edit_Playlist(View_Edit_Playlist view, Model_Edit_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    static JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Editar Biblioteca", true);
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
