package CE.Interfaz_Grafica.Create_Playlist;

import CE.Application;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Service;
import CE.Clases_Principales.User;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

    public void addplaylist(Playlist playlist){
        User user = Application.playlist_controller.getModel().getUser();
        Service.instance().addPlaylist(user,playlist);
        Application.playlist_controller.getModel().commit();
    }
    public String fecha(){
        String systemLocale = System.getProperty("user.language");
        String s;
        Locale locale;

        locale = new Locale(systemLocale);
        s = DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(new Date());
        return s;
    }
}
