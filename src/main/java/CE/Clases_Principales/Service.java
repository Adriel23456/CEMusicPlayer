package CE.Clases_Principales;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;

import javax.swing.*;

import java.security.Provider;

public class Service {


    /**
     * Este es un método el cual recibe un usuario del controller_login y se pregunta si ya existe
     * @param user
     * @return Si no existe retorna true y lo agrega a la lista de usuarios
     */
    public static boolean addUser(User user){
        DoubleLinkedList<User> users = CEMusicPlayer.instance().getUsers();
        for(int i = 0; i < users.getNumberOfElements(); i++){
            if(users.getElement(i).getEmail().equals(user.getEmail()))
                return false;
        }
        users.add(user);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente el nuevo usuario");
        return true;
    }
    /**
     * Este es un método el cual recibe una canción y la añade a la lista de canciones oficial
     * @param song Nombre del objeto Song a añadir
     */
    public static void registerSong(Song song){
        DoubleCircledLinkedList<Song> songs = CEMusicPlayer.instance().getSongs();
        songs.addCircled(song);
    }

    /**
     * Este es un método el cual recibe una canción y la añade a la lista de canciones de la biblioteca actual
     * @param new_song Nombre del objeto Song a añadir
     */
    public static void addSong_Playlist(Song new_song){
        //PLAYLIST NO ES UN SIGLETON NO SE COMO ARREGLAR ESTO XD
        DoubleCircledLinkedList<Song> song = Playlist.instance().getSongs();
        song.addCircled(new_song);
    }

    /**
     * Este es un método el cual recibe una playlist y la añade a la lista de playlist del usuario actual
     * @param playlist Nombre del objeto Playlist a añadir
     */
    public static void addPlaylist(Playlist playlist){
        //USER NO ES UN SIGLETON NO SE COMO ARREGLAR ESTO XD
        DoubleLinkedList<Playlist> playlists = User.instance().getPlaylists();
        playlists.add(playlist);
    }

    /**
     * Este es un método el cual recibe una canción de la lista oficial de canciones y cambia sus valores
     * @param edit_song Nombre del objeto Song que se creó para editar al oficial
     */
    public static void editSong(Song edit_song){
        //Se pregunta cuál es la canción de la lista oficial a la que le va a cambiar sus datos:
        DoubleCircledLinkedList<Song> songs = CEMusicPlayer.instance().getSongs();
        for (int i = 0; i < songs.getNumberOfElements(); i++){
            if (songs.getElement(i).getName().equals(edit_song.getName())){
                //Después, le cambia al elemento oficial los datos, por los del nuevo objeto creado
                songs.getElement(i).setAlbum(edit_song.getAlbum());
                songs.getElement(i).setArtist(edit_song.getArtist());
                songs.getElement(i).setGenre(edit_song.getGenre());
                songs.getElement(i).setYear(edit_song.getYear());
                songs.getElement(i).setLyrics(edit_song.getLyrics());
            }
        }
    }

    /**
     * Este es un método el cual recibe una playlist y la añade a la lista de playlist del usuario actual
     * @param playlist Nombre del objeto Playlist a añadir
     */
    public static void editPlaylist(Playlist edit_playlist){
        //Se pregunta cuál es la playlist de la lista de playlist del usuario actual:
        DoubleLinkedList<Playlist> playlists = User.instance().getPlaylists();
        for (int i = 0; i < playlists.getNumberOfElements(); i++){
            //ME OCUPO ASEGURAR QUE LA FECHA DE ESTE OBJETO TEMPORAL SEA IGUAL AL QUE SE QUIERE EDITAR
            if (playlists.getElement(i).getFecha().equals(edit_playlist.getFecha())){
                //Después, le cambia al elemento los datos, por los del nuevo objeto creado
                playlists.getElement(i).setName(edit_playlist.getName());
            }
        }
    }

    /**
     * Este es un método el cual recibe una playlist y la añade a la lista de playlist del usuario actual
     * @param playlist Nombre del objeto Playlist a añadir
     */
    public static void removePlaylist(Playlist remove_playlist){
        //Se pregunta cuál es la playlist de la lista de playlist del usuario actual:
        DoubleLinkedList<Playlist> playlists = User.instance().getPlaylists();
        for (int i = 0; i < playlists.getNumberOfElements(); i++){
            //ME OCUPO ASEGURAR QUE LA FECHA DE ESTE OBJETO TEMPORAL SEA IGUAL AL QUE SE QUIERE ELIMINAR
            if (playlists.getElement(i).getFecha().equals(remove_playlist.getFecha())){
                //Después, elimina al objeto playlist del actual usuario
                playlists.remove(i);
            }
        }
    }
}
