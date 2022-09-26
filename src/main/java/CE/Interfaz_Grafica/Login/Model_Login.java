package CE.Interfaz_Grafica.Login;

import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Clase de model para expresarle a la ventana login sus cambios
 */
public class Model_Login extends java.util.Observable {

    User current;
    List<User> usuarios;
    int modo;
    /**
     * Constructor del model
     */
    public Model_Login(){
        this.current = new User();
        this.usuarios = new ArrayList<>();
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