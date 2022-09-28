package CE.Clases_Principales;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;

import javax.swing.*;


public class Service {
    private static Service instance;
    static CEMusicPlayer data = CEMusicPlayer.instance();
    public static Service instance(){
        if (instance == null ){
            instance = new Service();
        }
        return instance;
    }

    /**
     * Este es un método el cual recibe un usuario del controller_login y se pregunta si ya existe
     * @param user
     * @return Si no existe retorna true y lo agrega a la lista de usuarios
     */
    public static boolean addUser(User user){
        DoubleLinkedList<User> users = data.getUsers();
        for(int i = 0; i < users.getNumberOfElements(); i++){
            if(users.getElement(i).getEmail().equals(user.getEmail())){
                return false;
            }
        }
        users.add(user);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente el nuevo usuario");
        return true;
    }

    /**
     * Este es un método el cual recibe una canción y la añade a la lista de canciones de la biblioteca actual
     * @param song Nombre del objeto Song a añadir
     * @param current_playlist Nombre de la playlist a la que se le va a añadir
     */
    public static void addSong_Playlist(Playlist current_playlist, Song song){
        for (int i = 0;i<current_playlist.getSongs().getNumberOfElements();i++){
            if (current_playlist.getSongs().getElement(i).getName().equals(song.getName())){
                JOptionPane.showMessageDialog(null,"No se puede repetir la canción");
                return;
            }
        }
        current_playlist.getSongs().addCircled(song);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente la canción");
    }

    /**
     * Este es un método el cual recibe una playlist y la añade a la lista de playlist del usuario actual
     * @param playlist Nombre del objeto Playlist a añadir
     */
    public static void addPlaylist(User current_user, Playlist playlist){
        for (int i = 0;i<current_user.getPlaylists().getNumberOfElements();i++){
            if (current_user.getPlaylists().getElement(i).getName().equals(playlist.getName())){
                JOptionPane.showMessageDialog(null,"No se puede repetir el nombre");
                return;
            }
        }
        current_user.getPlaylists().add(playlist);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente la biblioteca");
    }

    /**
     * Este es un método el cual recibe una canción de la lista oficial de canciones y cambia sus valores
     * @param edit_song Nombre del objeto Song que se creó para editar al oficial
     */
    public static void editSong(Song edit_song){
        //Se pregunta cuál es la canción de la lista oficial a la que le va a cambiar sus datos:
        DoubleCircledLinkedList<Song> songs = data.getSongs();
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
     * @param edit_playlist Objeto Playlist a cambiar
     */
    public static void editPlaylist(User current_user, Playlist edit_playlist, String new_name){
        for (int i = 0;i<current_user.getPlaylists().getNumberOfElements();i++){
            if (current_user.getPlaylists().getElement(i).getName().equals(new_name)){
                JOptionPane.showMessageDialog(null,"No se puede repetir el nombre");
                return;
            }
        }
        edit_playlist.setName(new_name);
    }

    public static Playlist PlaylistGet(String name, User current_User){
        for (int i = 0; i<current_User.getPlaylists().getNumberOfElements(); i++){
            if(current_User.getPlaylists().getElement(i).getName().equals(name)){
                return current_User.getPlaylists().getElement(i);
            }
        }
        return null;
    }
    public static Song SongGet(String name, DoubleCircledLinkedList<Song> original_playlist){
        for (int i = 0; i<original_playlist.getNumberOfElements(); i++){
            if(original_playlist.getElement(i).getName().equals(name)){
                System.out.println("SE SELECCIONO CORRECTAMENTE EL OBJETO DE SONG A AGREGAR");
                return original_playlist.getElement(i);
            }
        }
        return null;
    }

    public static void removePlaylist(Playlist playlist, User current_user){
        for (int i = 0; i<current_user.getPlaylists().getNumberOfElements(); i++){
            if(current_user.getPlaylists().getElement(i).getName().equals(playlist.getName())){
                current_user.getPlaylists().remove(i);
            }
        }
    }

    public DoubleLinkedList<Playlist> playlistSearch(String filtro){
        DoubleLinkedList<Playlist> Lista = new DoubleLinkedList<>();
        for (int i = 0;i<Application.playlist_controller.getModel().getUser().getPlaylists().getNumberOfElements();i++){
            if(filtro.equals(Application.playlist_controller.getModel().getUser().getPlaylists().getElement(i).getName())){
                Lista.add(Application.playlist_controller.getModel().getUser().getPlaylists().getElement(i));
            } else if (filtro.equals("")) {
                Lista.add(Application.playlist_controller.getModel().getUser().getPlaylists().getElement(i));
            }
        }
        return Lista;
    }
    public DoubleCircledLinkedList<Song> loadSongs(){
        DoubleCircledLinkedList<Song> originalsongs = new DoubleCircledLinkedList<Song>();
        Song song1 = new Song();
        song1.setName("As it was");
        song1.setGenre("Pop rock/Funk/Synth pop");
        song1.setArtist("Harry Styles");
        song1.setAlbum("Harry's House");
        song1.setYear("2022");
        song1.setLyrics
                ("Holdin' me back\n" +
                "Gravity's holdin' me back\n" +
                "I want you to hold out the palm of your hand\n" +
                "Why don't we leave it at that?\n" +
                "Nothin' to say\n" +
                "When everything gets in the way\n" +
                "Seems you cannot be replaced\n" +
                "And I'm the one who will stay, oh\n" +
                "In this world, it's just us\n" +
                "You know it's not the same as it was\n" +
                "In this world, it's just us\n" +
                "You know it's not the same as it was\n" +
                "As it was, as it was\n" +
                "You know it's not the same\n" +
                "Answer the phone\n" +
                "\"Harry, you're no good alone\n" +
                "Why are you sittin' at home on the floor?\n" +
                "What kind of pills are you on?\"\n" +
                "Ringin' the bell\n" +
                "And nobody's comin' to help\n" +
                "Your daddy lives by himself\n" +
                "He just wants to know that you're well, oh\n" +
                "In this world, it's just us\n" +
                "You know it's not the same as it was\n" +
                "In this world, it's just us\n" +
                "You know it's not the same as it was\n" +
                "As it was, as it was\n" +
                "You know it's not the same\n" +
                "Go home, get ahead, light-speed internet\n" +
                "I don't wanna talk about the way that it was\n" +
                "Leave America, two kids follow her\n" +
                "I don't wanna talk about who's doin' it first\n" +
                "As it was\n" +
                "You know it's not the same as it was\n" +
                "As it was, as it was");
        song1.setMP3File("Canciones/As it was.wav");
        Song song2 = new Song();
        song2.setName("Latch");
        song2.setGenre("Deep house/Dance/Electronica");
        song2.setArtist("Disclosure");
        song2.setAlbum("Settle");
        song2.setYear("2013");
        song2.setLyrics
                ("You lift my heart up\n" +
                "When the rest of me is down\n" +
                "You, you enchant me, even when you're not around\n" +
                "If there are boundaries, I will try to knock them down\n" +
                "I'm latching on babe\n" +
                "Now I know what I have found\n" +
                "I feel we're close enough\n" +
                "I wanna lock in your love\n" +
                "I think we're close enough\n" +
                "Could I lock in your love, baby?\n" +
                "Now I got you in my space\n" +
                "I won't let go of you\n" +
                "Got you shackled in my embrace\n" +
                "I'm latching on to you\n" +
                "Now I got you in my space\n" +
                "I won't let go of you\n" +
                "Got you shackled in my embrace\n" +
                "I'm latching on to you\"\n" +
                "I'm so encaptured, got me wrapped up in your touch\n" +
                "Feel so enamored, hold me tight within your clutch\n" +
                "How do you do it, you got me losing every breath\n" +
                "What did you give me to make my heart beat out my chest?\n" +
                "I feel we're close enough\n" +
                "I wanna lock in your love\n" +
                "I think we're close enough\n" +
                "Could I lock in your love, baby?\n" +
                "I feel we're close enough\n" +
                "I wanna lock in your love\n" +
                "I think we're close enough\n" +
                "Could I lock in your love, baby?\n" +
                "Now I got you in my space\n" +
                "I won't let go of you\n" +
                "Got you shackled in my embrace\n" +
                "I'm latching on to you\n" +
                "Now I got you in my space\n" +
                "I won't let go of you\n" +
                "Got you shackled in my embrace\n" +
                "I'm latching on to you\n" +
                "I'm latching on to you (I'm latching on to you)\n" +
                "I won't let go of you (I won't let go)\n" +
                "I'm latching on to you (I don't wanna let go)\n" +
                "I won't let go of you (I won't let go, I won't let go)\n");;
        song2.setMP3File("Canciones/Latch.wav");
        originalsongs.addCircled(song1);
        originalsongs.addCircled(song2);
        return originalsongs;
    }
    public void loadPlaylist(Playlist e){
        Application.songs_controller.getModel().setPlaylist(e);
        Application.add_songs_controller.getModel().setCurrent_playlist(e);
        Application.edit_song_controller.getModel().setCurrent_playlist(e);
        Application.songs_controller.getModel().commit();
    }
}
