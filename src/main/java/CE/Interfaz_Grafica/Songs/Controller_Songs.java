package CE.Interfaz_Grafica.Songs;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Service;
import CE.Clases_Principales.Song;
import CE.Interfaz_Grafica.Add_Songs.Controller_Add_Songs;
import CE.Interfaz_Grafica.Edit_Song.Controller_Edit_Song;

import javax.swing.*;

public class Controller_Songs {
    Controller_Edit_Song controller_edit_song;
    Controller_Add_Songs controller_add_songs;
    View_Songs view;
    Model_Songs model;

    public Controller_Songs(View_Songs view, Model_Songs model, Controller_Edit_Song controller_edit_song, Controller_Add_Songs controller_add_songs) {
        this.view = view;
        this.model = model;
        this.controller_edit_song = controller_edit_song;
        this.controller_add_songs = controller_add_songs;
        view.setController(this);
        view.setModel(model);
    }

    public void borrar(Song song){
        if (model.getListaSongs().getNumberOfElements() == 0){
            JOptionPane.showMessageDialog(null,"Favor seleccionar una canción");
        }
        else{
            Service.instance().removeSong(song,model.getPlaylist());
            buscar("");
        }
    }
    public void buscar(String filtro){
        DoubleCircledLinkedList<Song> rows = Service.instance().songSearch(filtro);
        model.setListaSongs(rows);
        model.commit();
    }
    public void add_song(){
        Application.add_songs_controller.show();
    }

    public void edit_song(){
        Application.edit_song_controller.show();
    }

    public View_Songs getView() {
        return view;
    }

    public void setView(View_Songs view) {
        this.view = view;
    }

    public Model_Songs getModel() {
        return model;
    }

    public void setModel(Model_Songs model) {
        this.model = model;
    }
}
