package Clases_Principales;

import Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;

/**
 * Esta es la clase lógica de la ventana de "Playlist", y, esta establecerá todos los métodos y atributos necesarios para que el controlador de la ventana pueda trabajar correctamente
 * @author Adriel
 */
public class Playlist {
    private DoubleCircledLinkedList<Song> songs;
    private String name;

    /**
     * Se establece el constructor de esta clase
     * @param songs Se establece que cada playlist (biblioteca), debera de tener una lista circular de canciones
     * @param name Se establece que cada playlist (biblioteca), debera de tener un nombre único
     */
    public Playlist(DoubleCircledLinkedList<Song> songs, String name) {
        this.songs = songs;
        this.name = name;
    }

    /**
     * Se establece el método para escribir todos los valores de la lista playlist en strings e imprimirlos
     * @return Esto retornará a todos los strings de la lista de canciones
     */
    @Override
    public String toString() {
        return ("Song{"+"name='"+name+'\''+", playlist='"+songs+'\''+'}');
    }

    public DoubleCircledLinkedList<Song> getSongs() {return songs;}
    public void setSongs(DoubleCircledLinkedList<Song> songs) {this.songs = songs;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


}