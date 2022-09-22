package CE.Clases_Principales;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * Esta es la clase lógica para la creación de las listas de canciones de la aplicación, y, esta establecerá todos los métodos necesarios para que el controlador de la ventana "Songs"
 * @author Adriel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {
    private String name;
    private String genre;
    private String artist;
    private String album;
    private String year;
    private String lyrics;
    private String MP3File;


    /**
     * Se establece el constructor de esta clase, muy importante para la creación de las instancias de esta
     * @param name nombre
     * @param gender genero
     * @param artist artista
     * @param album album
     * @param year año
     * @param lyrics letra
     * @param MP3File Ubicación del archivo mp3
     */
    public Song(String name, String gender, String artist, String album, String year, String lyrics, String MP3File) {
        this.name = name;
        this.genre = gender;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.lyrics = lyrics;
        this.MP3File = MP3File;
    }

    /**
     * Se establecen los valores predeterminados de la clase
     */
    public Song() {
        this.name = "";
        this.genre = "";
        this.artist = "";
        this.album = "";
        this.year = "";
        this.lyrics = "";
        this.MP3File = "";
    }

    public static void addSong(String[] array){
        Song song = new Song();
        for(int i = 0;i < array.length; i++){
            if (i == 0){
                song.name = array[0];
            }
            if (i == 1){
                song.genre = array[1];
            }
            if (i == 2){
                song.artist = array[2];
            }
            if (i == 3){
                song.album = array[3];
            }
            if (i == 4){
                song.year = array[4];
            }
            if (i == 5){
                song.lyrics = array[5];
            }
            if (i == 6){
                song.MP3File = array[6];
            }
        }
        //System.out.println(song.toString());
        CEMusicPlayer.addSong(song);
    }

    /**
     * Se establece el método para escribir todos los valores de la lista song en strings e imprimirlos
     * @return Este método retorna los valores asignados a la instancia de una clase Song
     */
    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", gender='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", year=" + year +
                ", lyrics='" + lyrics + '\'' +
                ", MP3File='"+ MP3File + '}';
    }

    public Song registerNewSong(String[] array){
        return new Song(array[0], array[1], array[2], array[3], array[4], array [5], array [6]);
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getGender() {return genre;}
    public void setGender(String gender) {this.genre = genre;}
    public String getArtist() {return artist;}
    public void setArtist(String artist) {this.artist = artist;}
    public String getAlbum() {return album;}
    public void setAlbum(String album) {this.album = album;}
    public String getYear() {return year;}
    public void setYear(String year) {this.year = year;}
    public String getLyrics() {return lyrics;}
    public void setLyrics(String lyrics) {this.lyrics = lyrics;}
    public String getMP3File() {return MP3File;}
    public void setMP3File(String MP3File) {this.MP3File = MP3File;}

}