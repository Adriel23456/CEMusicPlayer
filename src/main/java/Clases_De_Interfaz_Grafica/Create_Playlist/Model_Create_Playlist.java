package Clases_De_Interfaz_Grafica.Create_Playlist;

import java.util.Observer;

public class Model_Create_Playlist extends java.util.Observable {
    public Model_Create_Playlist(){
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
