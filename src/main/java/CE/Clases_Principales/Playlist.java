package CE.Clases_Principales;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;

/**
 * Esta es la clase lógica de la ventana de "Playlist", y, esta establecerá todos los métodos y atributos necesarios para que el controlador de la ventana pueda trabajar correctamente
 * @author Adriel
 */
public class Playlist {
    private DoubleCircledLinkedList<Song> songs_Playlist;
    private String name;
    private String fecha;

    /**
     * Se establece el constructor de esta clase vacio
     * @param songs Se establece que cada playlist (biblioteca), debera de tener una lista circular de canciones
     * @param name Se establece que cada playlist (biblioteca), debera de tener un nombre único
     */
    public Playlist() {
        this.songs_Playlist = new DoubleCircledLinkedList<Song>();
        this.name = "";
        this.fecha = "";
    }
    /**
     * Se establece el constructor de esta clase
     * @param songs Se establece que cada playlist (biblioteca), debera de tener una lista circular de canciones
     * @param name Se establece que cada playlist (biblioteca), debera de tener un nombre único
     */
    public Playlist(DoubleCircledLinkedList<Song> songs, String name, String fecha) {
        this.songs_Playlist = songs;
        this.name = name;
        this.fecha = fecha;
    }


    public DoubleCircledLinkedList<Song> getSongs() {return songs_Playlist;}
    public void setSongs(DoubleCircledLinkedList<Song> songs) {this.songs_Playlist = songs;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
}