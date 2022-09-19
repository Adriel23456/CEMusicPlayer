package Clases_Principales;

import Clases_De_Estructuras_De_Datos.DoubleLinkedList;

/**
 * Esta es la clase lógica de la ventana de "login", y, esta establecerá todos los métodos necesarios para que el controlador de la ventana pueda trabajar correctamente
 * @author Adriel
 */
public class Login {
    /**
     * Este método nos permite registrar un nuevo usuario a la aplicación
     * @return Retorna un nuevo usuario
     */
    public User registerNewUser(){
        return new User();
    }

    /**
     * Este método nos permite preguntarnos si el correo y contraseña ingresados son los mismos
     * @param email El correo ingresado por el usuario
     * @param password La contraseña ingresada por el usuario
     * @return Puede retornar que para la información ingresada de tal correo debera de estar relacionado a una contraseña, pero, si esto no es cierto, retorna falso.
     */
    public boolean loginExistingUser(String email, String password){
        DoubleLinkedList<User> users = CEMusicPlayer.instance().getUsers();
        for (int i = 0; i < users.getNumberOfElements(); i++){
            if (users.getElement(i).getEmail().equals(email)){
                return users.getElement(i).isPassword(password);
            }
        }
        return false;
    }
}

