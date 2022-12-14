package CE.Clases_Principales;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;

import javax.swing.*;

/**
 * Esta es la clase lógica de la ventana de "login", y, esta establecerá todos los métodos necesarios para que el controlador de la ventana pueda trabajar correctamente
 * @author Adriel
 */
public class Login {
    private static Login instance;

    public static Login instance(){
        if (instance == null ){
            instance = new Login();
        }
        return instance;
    }

    /**
     * Este método nos permite registrar un nuevo usuario a la aplicación
     * @return Retorna un nuevo usuario
     */
    public User registerNewUser(String[] array){
        return new User(new DoubleLinkedList<Playlist>(), array [0], array [1], array [2], array [3], new DoubleLinkedList<Song>());
    }

    /**
     * Este método nos permite preguntarnos si el correo y contraseña ingresados son los mismos para la autenticacion
     * @param email El correo ingresado por el usuario
     * @param password La contraseña ingresada por el usuario
     * @return Puede retornar true si, la información ingresada de tal correo esta relacionada á una contraseña, pero, si esto no es cierto, retorna falso.
     */
    public boolean loginExistingUser(String email, String password){
        DoubleLinkedList<User> users = CEMusicPlayer.instance().getUsers();
        for (int i = 0; i < users.getNumberOfElements(); i++){
            if (users.getElement(i).getEmail().equals(email)){
                if (users.getElement(i).getPassword().equals(password)){
                    Application.playlist_controller.getModel().setUser(users.getElement(i));
                    Application.songs_controller.getModel().setPlaylist(new Playlist());
                    Application.songs_controller.getModel().commit();
                    Application.playlist_controller.getModel().commit();
                    return true;
                }
            }
        }
        return false;
    }
}

