package CE.Interfaz_Grafica.Login;

import CE.Application;
import CE.Clases_Principales.CEMusicPlayer;
import CE.Clases_Principales.Login;
import CE.Clases_Principales.Service;
import CE.Clases_Principales.User;

import javax.swing.*;
import java.awt.*;

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

    static JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Autenticación", true);
        dialog.setSize(400,475);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+230,location.y+75);
        dialog.setVisible(true);
    }
    public void hide(){
        dialog.dispose();
    }

    /**
     * Se crea un método en el controller para obtener los valores escritos en la view y crear un array de Strings con esa información
     * @return Generara un return de un método desde la clase de CEMusicPlayer, en donde, agregara a la lista de usuarios de la aplicación al usuario recién creado.
     */
    public boolean addUser(){
        User user = Login.instance().registerNewUser(new String[]{
                view.getUsuario().getText(),
                view.getCorreo().getText(),
                view.getProvincia().getSelectedItem().toString(),
                view.getContraseña().getText()
        });
        return Service.addUser(user);
    }

    /**
     * Se crea un método para autenticar a un usuario
     * @return retorna un metodo en la clase de Login, para preguntarle a la lista principal de usuarios si existe el usuario
     */
    public boolean loginUser(){
        String correo_iniciar_sesion = view.getCorreo_iniciosesion().getText();
        String contraseña_iniciar_sesion = view.getContraseña_iniciosesion().getText();
        return Login.instance().loginExistingUser(correo_iniciar_sesion, contraseña_iniciar_sesion);
    }
    public View_Login getView(){
        return view;
    }



}
