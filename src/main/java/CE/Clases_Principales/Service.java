package CE.Clases_Principales;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Interfaz_Grafica.Playlist.View_Playlist;

import javax.swing.*;

import static java.lang.Boolean.FALSE;


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
        Application.songs_controller.getModel().getListaSongs().addCircled(song);
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
     */
    public static void editSong(String Name, String Genero, String Artista,String Album,String Ano, String Letra){
        //Se pregunta cuál es la canción de la lista oficial a la que le va a cambiar sus datos:
        DoubleCircledLinkedList<Song> songs = data.getSongs();
        for (int i = 0; i < songs.getNumberOfElements(); i++){
            if (songs.getElement(i).getName().equals(Name)){
                //Después, le cambia al elemento oficial los datos, por los del nuevo objeto creado
                songs.getElement(i).setGenre(Genero);
                songs.getElement(i).setArtist(Artista);
                songs.getElement(i).setAlbum(Album);
                songs.getElement(i).setYear(Ano);
                songs.getElement(i).setLyrics(Letra);
                Application.add_songs_controller.getModel().setListaSongsOficial(songs);
                Application.songs_controller.getModel().commit();
                JOptionPane.showMessageDialog(null,"Se cambio correctamente la información de la canción");
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
                return original_playlist.getElement(i);
            }
        }
        return null;
    }
    public static int SongGet2(Song song){
        DoubleLinkedList<Song> favoritesongsuUser = Application.playlist_controller.getModel().getUser().getFavoritesongs();
        for (int i = 0; i<favoritesongsuUser.getNumberOfElements(); i++){
            if(favoritesongsuUser.getElement(i).getName().equals(song.getName())){
                return i;
            }
        }
        return 0;
    }

    public static void removePlaylist(Playlist playlist, User current_user){
        for (int i = 0; i<current_user.getPlaylists().getNumberOfElements(); i++){
            if(current_user.getPlaylists().getElement(i).getName().equals(playlist.getName())){
                if (Application.songs_controller.getModel().getPlaylist().equals(playlist)){
                    View_Playlist.playlistselected[0] = FALSE;
                    Application.songs_controller.getModel().setPlaylist(new Playlist());
                    Application.songs_controller.getModel().commit();
                }
                current_user.getPlaylists().remove(i);
                JOptionPane.showMessageDialog(null,"Se elimino correctamente la biblioteca");
            }
        }
        return;
    }


    public static void removeSong(Song song, Playlist current_playlist){
        for (int i = 0;i<current_playlist.getSongs().getNumberOfElements(); i++){
            if(current_playlist.getSongs().getElement(i).getName().equals(song.getName())){
                current_playlist.getSongs().remove(i);
                JOptionPane.showMessageDialog(null,"Se elimino correctamente la canción");
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
    public DoubleCircledLinkedList<Song> songSearch(String filtro){
        DoubleCircledLinkedList<Song> Lista = new DoubleCircledLinkedList<>();
        for (int i = 0;i<Application.songs_controller.getModel().getPlaylist().getSongs().getNumberOfElements();i++){
            if(filtro.equals(Application.songs_controller.getModel().getPlaylist().getSongs().getElement(i).getName())){
                Lista.addCircled(Application.songs_controller.getModel().getPlaylist().getSongs().getElement(i));
            } else if (filtro.equals("")) {
                Lista.addCircled(Application.songs_controller.getModel().getPlaylist().getSongs().getElement(i));
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
        Song song3 = new Song();
        song3.setName("MIRÁ MAMÁ");
        song3.setGenre("Urbano latino");
        song3.setArtist("WOS");
        song3.setAlbum("Oscuro éxtasis");
        song3.setYear("2021");
        song3.setLyrics(
                "Yo me vi largar las palabras, como un aguacero\n" +
                        "Pensamientos vienen muchos, solo algunos son sincero'\n" +
                        "¿Qué voy a hacer si nunca me basé en los cero'?\n" +
                        "Tengo un nudo en la garganta y en la panza un agujero\n" +
                        "Sé que todo esto es pasajero\n" +
                        "La agonía del enfermo, el amor en el verano\n" +
                        "Su calor en el invierno\n" +
                        "Pero la veo y caigo en la trampa de sentir que hay algo eterno\n" +
                        "\"¿Cómo estás?\" Le contesto que no sé llorar\n" +
                        "Por eso dibujo lágrimas\n" +
                        "Ya se humedeció toda la página, así que imaginá\n" +
                        "Al menos no soy una máquina\n" +
                        "¿Será que no quiero que esto muera y que se olviden de mí?\n" +
                        "Si te soy sincero\n" +
                        "¿Será que no quiero darme cuenta que los que les creí\n" +
                        "No eran tan sincero'?\n" +
                        "Mirá mamá, estoy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirame acá, estoy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirá mamá, 'toy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirá mamá, estoy arriba\n" +
                        "Y te juro que no hay nada más\n" +
                        "Todo se deshace y quiero irme\n" +
                        "Cuando no puedo pisar firme en el mismo lugar que antes\n" +
                        "Pero todo son instante' y escapar no sirve\n" +
                        "Para buscar ser libre nunca se hace tarde\n" +
                        "Y ahora entendí\n" +
                        "Que no todo está bien pero está bien así\n" +
                        "Una temporada de poner énfasis\n" +
                        "En entender el lado oscuro de este éxtasis\n" +
                        "Y no es que sea frágil\n" +
                        "Es que tengo la nostalgia con el \"Sí\" muy fácil\n" +
                        "Sé que es difícil 'tar al lado mío\n" +
                        "Les da náuseas el vaivén de lo que vivo\n" +
                        "Te preguntabas por qué estando mojado me río\n" +
                        "Es que me empapa este rocío compuesto por recuerdos de crío\n" +
                        "En un banco rimando con frío\n" +
                        "Amando a los mío', tomando y tentando al olvido\n" +
                        "Y ahora dudo si eso tuyo era amor de verdad\n" +
                        "O buscabas un muñeco pa' mostrar\n" +
                        "Y no funcionó conmigo\n" +
                        "No soy un placebo diseñado pa' engañar tu vacío\n" +
                        "¿Será que no quiero que esto muera y que se olviden de mí?\n" +
                        "Si te soy sincero\n" +
                        "¿Será que no quiero darme cuenta que los que les creí\n" +
                        "No eran tan sincero'?\n" +
                        "Mirá mamá, estoy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirame acá, estoy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirá mamá, 'toy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mirá mamá, estoy arriba\n" +
                        "Y te juro que no hay nada más, eh\n" +
                        "Mirá mamá, 'toy arriba\n" +
                        "Y te juro que no hay nada más que la vida\n" +
                        "Mira mamá, estoy arriba\n" +
                        "Y te juro que no hay nada más"
        );;
        song3.setMP3File("Canciones/MIRÁ MAMÁ.wav");
        Song song4 = new Song();
        song4.setName("Psycho (feat. Ty Dolla $ign)");
        song4.setGenre("Hip Hop/Electropop");
        song4.setArtist("Post Malone/feat(Ty Dolla $ign)");
        song4.setAlbum("Beerbongs and Bentleys");
        song4.setYear("2018");
        song4.setLyrics(
                "Damn, my AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Come with the Tony Romo for clowns and all the bozos\n" +
                        "My AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Don't act like you my friend when I'm rollin' through my ends, though\n" +
                        "\n" +
                        "You stuck in the friend zone, I tell that four-five the fifth\n" +
                        "Hunnid bands inside my shorts, DeChino the shit\n" +
                        "Try to stuff it all in, but it don't even fit\n" +
                        "Know that I been with the shits ever since a jit\n" +
                        "I made my first million, I'm like: Shit, this is it\n" +
                        "30 for a walkthrough, man, we had that bitch lit\n" +
                        "Had so many bottles, gave ugly girl a sip\n" +
                        "Out the window of the Benzo, we get seen in the rent'\n" +
                        "And I'm like: Whoa, man, my neck so goddamn cold\n" +
                        "Diamonds wet, my t-shirt soaked\n" +
                        "I got homies, let it go, oh\n" +
                        "My money thick, won't ever fold\n" +
                        "She said: Can I have some to hold?\n" +
                        "And I can't ever tell you no\n" +
                        "\n" +
                        "Damn, my AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Come with the Tony Romo for clowns and all the bozos\n" +
                        "My AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Don't act like you my friend when I'm rollin' through my ends, though\n" +
                        "\n" +
                        "[Ty Dolla $ign]\n" +
                        "The AP goin' psycho, my Rollie goin' brazy\n" +
                        "I'm hittin' lil' mama, she wanna have my babies\n" +
                        "It's fifty on the pinky, chain so stanky\n" +
                        "You should see the whip, promise I can take yo' bitch\n" +
                        "Dolla ridin' in an old school Chevy, it's a drop top\n" +
                        "Boolin' with a thot-thot, she gon' give me top-top\n" +
                        "Just one switch, I can make the ass drop\n" +
                        "Ayy, take you to the smoke shop\n" +
                        "We gon' get high, ayy, we gon' hit Rodeo\n" +
                        "Dial up Valentino, we gon' hit Pico\n" +
                        "Take you where I'm from, take you to the slums\n" +
                        "This ain't happen overnight, no, these diamonds real bright\n" +
                        "Saint Laurent jeans, still in my Vans though\n" +
                        "All VVS', put you in a necklace\n" +
                        "Girl, you look beautiful tonight\n" +
                        "Stars on the roof, they matching with the jewelry\n" +
                        "\n" +
                        "[Post Malone]\n" +
                        "Damn, my AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Come with the Tony Romo for clowns and all the bozos\n" +
                        "My AP goin' psycho, lil' mama bad like Michael\n" +
                        "Can't really trust nobody with all this jewelry on you\n" +
                        "My roof look like a no-show, got diamonds by the boatload\n" +
                        "Don't act like you my friend when I'm rollin' through my ends, though"
        );;
        song4.setMP3File("Canciones/Psycho (feat. Ty Dolla Sign).wav");
        Song song5 = new Song();
        song5.setName("Stuck With Me");
        song5.setGenre("Electropop/Dance pop");
        song5.setArtist("The Neighbourhood");
        song5.setAlbum("The Neighbourhood");
        song5.setYear("2018");
        song5.setLyrics(
                "Now I'm feeling guilty for it\n" +
                        "Didn't wanna leave\n" +
                        "I got caught up in the forest\n" +
                        "Hangin' with the trees\n" +
                        "Realised I'm less important\n" +
                        "Than I thought I'd be\n" +
                        "I'm not tellin' you for any certain reason but\n" +
                        "Now I'm feelin' guilty for it\n" +
                        "I didn't wanna leave, no\n" +
                        "I got caught up in the forest\n" +
                        "Hangin' with the trees, yeah, yeah\n" +
                        "Realized I'm less important (oh, yeah)\n" +
                        "Than I thought I'd be, yeah\n" +
                        "I'm not tellin' you for any certain reasons but\n" +
                        "I just want your empathy\n" +
                        "Our lives keep on gettin' shorter\n" +
                        "Losin' opportunity\n" +
                        "There might be some other ways of looking at it but\n" +
                        "That's just what I see\n" +
                        "I been gettin' over myself\n" +
                        "Thinkin' about what you need\n" +
                        "Then I realised that neither of us matter\n" +
                        "What's reality, yeah?\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with you\n" +
                        "Couldn't be more different than me\n" +
                        "So each time we agree\n" +
                        "I feel fulfilled\n" +
                        "You always end up stickin' to me\n" +
                        "Somehow, somehow\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me\n" +
                        "So I guess I'll be sticking with\n" +
                        "You are stuck with me"
        );;
        song5.setMP3File("Canciones/Stuck with me.wav");
        Song song6 = new Song();
        song6.setName("The Spins");
        song6.setGenre("Hip-hop/Rap");
        song6.setArtist("Mac Miller");
        song6.setAlbum("K.I.D.S");
        song6.setYear("2010");
        song6.setLyrics(
                "Dope shit like that Jerm\n" +
                        "Oh hi\n" +
                        "Welcome back to K.I.D.S\n" +
                        "Umm, follow your dreams\n" +
                        "Yeah!\n" +
                        "Wanna get a mansion\n" +
                        "A jacuzzi, a theater to watch my movies\n" +
                        "A couple whips and lots of fancy things\n" +
                        "The kids they call the Goonies\n" +
                        "I see the future, crystal ball\n" +
                        "Mirror, mirror hangin' on the wall\n" +
                        "Who the flyest white boy of them dem all?\n" +
                        "Got your girlfriend screenin' all the calls\n" +
                        "She bubblin', we fuckin' then you cuddlin'\n" +
                        "Like baby where the fuck you been?\n" +
                        "Don't wanna tell you she in love with him\n" +
                        "So, so, we ain't sayin' nothing\n" +
                        "You could probably tell she bluffin'\n" +
                        "'Cause she kiss you with the mouth\n" +
                        "She gave me head with my concussion\n" +
                        "Yeah she blushin', all red\n" +
                        "Wanna rush and go to bed\n" +
                        "You interrogate that bitch like you the feds\n" +
                        "So she says\n" +
                        "She in love with a rock star, rock star\n" +
                        "Wanna smoke my weed\n" +
                        "So she asks me where the tops are, tops are\n" +
                        "Oh, oh, oh (top drawer, haha, yeah)\n" +
                        "Honey, I need you 'round (haha)\n" +
                        "I know, I know (just some motherfuckin' kids)\n" +
                        "Oh, oh, oh\n" +
                        "Honey, I need you 'round (make money, fuck bitches)\n" +
                        "I know, I know (yeah, Pittsburgh, hey, Jerm, hey)\n" +
                        "These hoes is drunk, wanna come and smoke this blunt\n" +
                        "Then let me take 'em home and do anything I want\n" +
                        "I said, \"Baby, I can ride you, just let me get inside you\n" +
                        "I can take you higher if you hit this vaporizer\"\n" +
                        "I got that dope dick, I'll be your supplier\n" +
                        "You grabbin' on my sheets and hittin' notes like you Mariah\n" +
                        "Obsessed with me\n" +
                        "Undress a freak on ecstasy\n" +
                        "I'm out and then she textin' me\n" +
                        "Like, \"What you doin' next week, next week?\" (yeah)\n" +
                        "Hear me now!\n" +
                        "I'm down on knees and praying\n" +
                        "Though my faith is weak\n" +
                        "Without you so please baby please\n" +
                        "Give us a chance\n" +
                        "Make amends and I will stand up 'til the end\n" +
                        "A million times, a trillion more\n" +
                        "Oh, oh, oh\n" +
                        "Honey, I need you 'round (I'm drunk as fuck)\n" +
                        "I know, I know (most Dope, bitch, hey)\n" +
                        "Oh, oh, oh (K.I.D.S., what's up?)\n" +
                        "Honey, I need you 'round (I'm high as fuck, yeah, yes, sir)\n" +
                        "I know, I know (oh, I graduated, oh yeah, I just graduated high school, haha)\n" +
                        "Hey, homie\n" +
                        "Don't be mad that your girl loves me (don't cut anything yet)\n" +
                        "It's not my fault (yeah)\n" +
                        "I'm just doin' me (haha)\n" +
                        "If your girl love me, let her love me, you feel me?\n" +
                        "So, baby smile (uh-huh)\n" +
                        "Baby, don't cry\n" +
                        "I will only fly\n" +
                        "With you by my side"
        );;
        song6.setMP3File("Canciones/Stuck with me.wav");
        originalsongs.addCircled(song1);
        originalsongs.addCircled(song2);
        originalsongs.addCircled(song3);
        originalsongs.addCircled(song4);
        originalsongs.addCircled(song5);
        originalsongs.addCircled(song6);
        return originalsongs;
    }
    public void loadPlaylist(Playlist e){
        Application.songs_controller.getModel().setPlaylist(e);
        Application.add_songs_controller.getModel().setCurrent_playlist(e);
        Application.edit_song_controller.getModel().setCurrent_playlist(e);
        Application.songs_controller.getModel().commit();
    }
}
