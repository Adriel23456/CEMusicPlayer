package CE.Interfaz_Grafica.Add_Songs;


import CE.Application;
import CE.Clases_Principales.*;

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
        dialog = new JDialog(Application.window,"Añadir Nueva Canción", true);
        dialog.setSize(475,500);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+200,location.y+80);
        dialog.setVisible(true);
    }
    public void hide(){
        dialog.dispose();
    }
    public View_Add_Songs getView() {
        return view;
    }
    public void setView(View_Add_Songs view) {
        this.view = view;
    }
    public Model_Add_Songs getModel() {
        return model;
    }
    public void setModel(Model_Add_Songs model) {
        this.model = model;
    }
    public void addSong(Song song){
        Playlist playlist = Application.songs_controller.getModel().getPlaylist();
        Service.instance().addSong_Playlist(playlist,song);
        Application.songs_controller.getModel().commit();
        Application.playlist_controller.getModel().commit();
    }
}
