package CE.Interfaz_Grafica.Playlist;

import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.User;
import java.util.Observer;

public class Model_Playlist extends java.util.Observable {
    User user;
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    DoubleLinkedList<Playlist> Lista;
    public DoubleLinkedList<Playlist> getLista() {
        return Lista;
    }
    public void setLista(DoubleLinkedList<Playlist> lista) {
        Lista = lista;
    }

    public Model_Playlist(){
        this.setLista(new DoubleLinkedList<Playlist>());
        user = new User();
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
