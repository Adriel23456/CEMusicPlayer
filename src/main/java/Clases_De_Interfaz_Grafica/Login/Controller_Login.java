package Clases_De_Interfaz_Grafica.Login;

import Clases_Principales.CEMusicPlayer;
import Clases_Principales.Login;
import Clases_Principales.Song;
import Clases_Principales.User;

import javax.swing.*;

/**
 * Se genera a la clase de Controller_login para establecer todos los métodos que necesitara, estos métodos reciben atributos de la clase view_login
 */
public class Controller_Login {
    View_Login view;
    Model_Login model;

    /**
     * Se crea un constructor para la clase de controller, en donde se establecerán cuáles clases serán las relacionadas ál controller (Model_login, View_login)
     * @param view Recibe a la clase de view_login
     * @param model Recibe a la clase de model_login
     */
    public Controller_Login(View_Login view, Model_Login model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    /**
     * Se crea un método en el controller para obtener los valores escritos en la view y crear un array de Strings con esa información
     * @return Generara un return de un método desde la clase de CEMusicPlayer, en donde, agregara a la lista de usuarios de la aplicación al usuario recién creado.
     */
    public boolean addUser(){
        User user = Login.instance().registerNewUser(new String[]{
                view.getUsuario().getText().toString(),
                view.getCorreo().getText().toString(),
                view.getProvincia().getSelectedItem().toString(),
                view.getContraseña().getText().toString()
        });
        return CEMusicPlayer.instance().addUser(user);
    }

    /**
     * Se crea un método para autenticar a un usuario
     * @return retorna un metodo en la clase de Login, para preguntarle a la lista principal de usuarios si existe el usuario
     */
    public boolean loginUser(){
        String correo_iniciar_sesion = view.getCorreo_iniciosesion().getText().toString();
        String contraseña_iniciar_sesion = view.getContraseña_iniciosesion().getText().toString();
        return Login.instance().loginExistingUser(correo_iniciar_sesion, contraseña_iniciar_sesion);
    }

    public static void cambio_a_playlist(){
        //window.remove(view_playlist.getPanel())
    }


}
