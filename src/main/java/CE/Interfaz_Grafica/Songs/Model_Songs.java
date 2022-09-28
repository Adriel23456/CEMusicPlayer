package CE.Interfaz_Grafica.Songs;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Song;
import java.util.Observer;

public class Model_Songs extends java.util.Observable {
    Playlist playlist;
    public Playlist getPlaylist() {return playlist;}
    public void setPlaylist(Playlist playlist) {this.playlist = playlist;}
    DoubleCircledLinkedList<Song> ListaSongs;
    public DoubleCircledLinkedList<Song> getListaSongs() {return ListaSongs;}
    public void setListaSongs(DoubleCircledLinkedList<Song> listaSongs) {ListaSongs = listaSongs;}

    public Model_Songs(){
        this.setListaSongs(new DoubleCircledLinkedList<Song>());
        playlist = new Playlist();
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
