package Clases_Principales;

import Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import Clases_De_Estructuras_De_Datos.DoubleLinkedList;

/**
 * Esta es la clase main y, va a relacionar el funcionamiento lógico de todas las otras clases principales e iniciar el programa llamando al controlador de la ventana Login.
 * @author Adriel
 */
public class CEMusicPlayer {
    private DoubleCircledLinkedList<Song> songs;
    private DoubleLinkedList<User> users;
    private String name;

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
        }
        return instance;
    }

    public DoubleCircledLinkedList<Song> getSongs() {return songs;}
    public void setSongs(DoubleCircledLinkedList<Song> songs) {this.songs = songs;}
    public DoubleLinkedList<User> getUsers() {return users;}
    public void setUsers(DoubleLinkedList<User> users) {this.users = users;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
