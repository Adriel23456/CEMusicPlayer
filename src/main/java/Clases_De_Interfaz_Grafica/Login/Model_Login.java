package Clases_De_Interfaz_Grafica.Login;

import java.util.Observer;

/**
 * Clase de model para expresarle a la ventana login sus cambios
 */
public class Model_Login extends java.util.Observable {
    /**
     * Constructor del model
     */
    public Model_Login(){
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