package Clases_De_Interfaz_Grafica.Add_Songs;

import java.util.Observer;

public class Model_Add_Songs extends java.util.Observable {
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
