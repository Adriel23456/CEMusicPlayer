package CE.Clases_Principales;

import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;

/**
 * Esta es la clase lógica de la creación de los usuarios, y esta, establecerá los métodos necesarios para garantizar la verificación de un usuario
 * @author Adriel
 */
public class User {
    private DoubleLinkedList<Playlist> playlists;
    private String name;
    private String email;
    private String province;
    private String password;

    /**
     * Constructor de los usuarios para la primera vez que se llama a la funcion
     */
    public User() {
        playlists = new DoubleLinkedList<>();
        name = "";
        this.email = "";
        this.province = "";
        this.password = "";
    }

    /**
     * Constructor de los usuarios para cuando se vuelve a llamar
     * @param playlists
     * @param name
     * @param email
     * @param province
     * @param password
     */
    public User(DoubleLinkedList<Playlist> playlists, String name, String email, String province, String password) {
        this.playlists = playlists;
        this.name = name;
        this.email = email;
        this.province = province;
        this.password = password;
    }


    public DoubleLinkedList<Playlist> getPlaylists() {return playlists;}
    public void setPlaylists(DoubleLinkedList<Playlist> playlists) {this.playlists = playlists;}
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
