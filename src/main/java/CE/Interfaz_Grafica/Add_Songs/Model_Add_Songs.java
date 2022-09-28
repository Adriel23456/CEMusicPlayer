package CE.Interfaz_Grafica.Add_Songs;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_Principales.CEMusicPlayer;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Song;

import java.util.Observer;

public class Model_Add_Songs extends java.util.Observable {
    Playlist current_playlist;
    public Playlist getCurrent_playlist() {return current_playlist;}
    public void setCurrent_playlist(Playlist current_playlist) {
        this.current_playlist = current_playlist;
    }
    DoubleCircledLinkedList<Song> ListaSongsOficial;
    public DoubleCircledLinkedList<Song> getListaSongsOficial() {
        setListaSongsOficial(CEMusicPlayer.instance().getSongs());
        return ListaSongsOficial;
    }
    public void setListaSongsOficial(DoubleCircledLinkedList<Song> listaSongsOficial) {ListaSongsOficial = listaSongsOficial;}

    public Model_Add_Songs(){
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
