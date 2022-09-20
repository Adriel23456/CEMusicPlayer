package Clases_Principales;

import Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import Clases_De_Estructuras_De_Datos.DoubleLinkedList;

import javax.swing.*;

/**
 * Esta es la clase main y, va a relacionar el funcionamiento lógico de todas las otras clases principales e iniciar el programa llamando al controlador de la ventana Login.
 * @author Adriel
 */
public class CEMusicPlayer {
    private static DoubleCircledLinkedList<Song> songs;
    private static DoubleLinkedList<User> users;

    /**
     * Este es un atributo estático para establecer que CEMusicPlayer es una instancia.
     */
    private static CEMusicPlayer instance;

    /**
     * Este es un método el cual agarra a la clase y, se asegura de crear una instancia de esta en caso de que no exista alguna.
     * @return Esto retorna la instancia de la clase
     */
    public static CEMusicPlayer instance(){
        if (instance == null ){
            instance = new CEMusicPlayer();
            users = new DoubleLinkedList<User>();
            songs = new DoubleCircledLinkedList<Song>();
        }
        return instance;
    }

    /**
     * Este es un método el cual recibe un usuario del controller_login y se pregunta si ya existe
     * @param user
     * @return Si no existe retorna true y lo agrega a la lista de usuarios
     */
    public static boolean addUser(User user){
        for(int i = 0;i < users.getNumberOfElements(); i++){
            if(users.getElement(i).getEmail().equals(user.getEmail()))
                return false;
        }
        users.add(user);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente el nuevo usuario");
        return true;
    }


    public DoubleCircledLinkedList<Song> getSongs() {return songs;}
    public void setSongs(DoubleCircledLinkedList<Song> songs) {this.songs = songs;}
    public DoubleLinkedList<User> getUsers() {return users;}
    public void setUsers(DoubleLinkedList<User> users) {this.users = users;}
}
