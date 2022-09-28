package CE.Interfaz_Grafica.Edit_Song;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Song;

import java.util.Observer;

public class Model_Edit_Song extends java.util.Observable{
    Playlist current_playlist;
    public Playlist getCurrent_playlist() {return current_playlist;}
    public void setCurrent_playlist(Playlist current_playlist) {
        this.current_playlist = current_playlist;
    }
    DoubleCircledLinkedList<Song> ListaSongsOficial;
    public DoubleCircledLinkedList<Song> getListaSongsOficial() {return ListaSongsOficial;}
    public void setListaSongsOficial(DoubleCircledLinkedList<Song> listaSongsOficial) {ListaSongsOficial = listaSongsOficial;}
    public Song selected_song = new Song();
    public Song getSelected_song() {return selected_song;}
    public void setSelected_song(Song selected_song) {this.selected_song = selected_song;}

    public Model_Edit_Song(){
    }
    /**
     * Método que relaciona el modelo con la view
     * @param o   an observer to be added.
     */
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        commit();
    }
    /**
     * Método que realiza los cambios a la view
     */
    public void commit() {
        setChanged();
        notifyObservers(null);
    }
}
