package CE.Interfaz_Grafica.Edit_Song;

import CE.Application;
import CE.Clases_Principales.Service;
import CE.Clases_Principales.Song;

import javax.swing.*;
import java.awt.*;

public class Controller_Edit_Song {
    View_Edit_Song view;
    Model_Edit_Song model;

    public Controller_Edit_Song(View_Edit_Song view, Model_Edit_Song model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    static JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Crear Biblioteca Nueva", true);
        dialog.setSize(450,950);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+225,location.y-100);
        dialog.setVisible(true);
    }
    public void hide(){
        dialog.dispose();
    }
    public View_Edit_Song getView() {return view;}
    public void setView(View_Edit_Song view) {this.view = view;}
    public Model_Edit_Song getModel() {
        return model;
    }
    public void setModel(Model_Edit_Song model) {
        this.model = model;
    }
    public void edit(String Name, String Genero, String Artista,String Album,String Ano, String Letra){
        Service.instance().editSong(Name, Genero, Artista,Album,Ano, Letra);
    }
}
