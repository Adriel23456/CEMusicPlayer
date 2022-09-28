package CE.Interfaz_Grafica.Edit_Playlist;

import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Song;
import CE.Clases_Principales.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Model_Edit_Playlist extends java.util.Observable {
    Playlist current;
    DoubleLinkedList<Playlist> playlists;
    User user;

    public Model_Edit_Playlist(){
        this.current = new Playlist();
        this.playlists = new DoubleLinkedList<>();
        this.user = new User();
    }
    public Playlist getCurrent() {return current;}

    public DoubleLinkedList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(DoubleLinkedList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setCurrent(Playlist current) {
        this.current = current;
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
