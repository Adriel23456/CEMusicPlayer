import Clases_Principales.CEMusicPlayer;

import javax.swing.*;

public class Application {
    /**
     * Se establecen los atributos de los controllers de todas las ventanas, fuera del método main para llamarlos en cualquier situación
     */
    public static JFrame window;
    public static Clases_De_Interfaz_Grafica.Login.Controller_Login login_controller;

    /**
     * Se establece la clase main, la cual inicia el programa con la iniciación de la ventana Login
     * @param args
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e){}

        Clases_De_Interfaz_Grafica.Login.Model_Login login_model = new Clases_De_Interfaz_Grafica.Login.Model_Login();
        Clases_De_Interfaz_Grafica.Login.View_Login login_view = new Clases_De_Interfaz_Grafica.Login.View_Login();
        login_controller = new Clases_De_Interfaz_Grafica.Login.Controller_Login(login_view,login_model);

        window = new JFrame();
        window.setSize(500,550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISTEMA...");
        window.setVisible(true);
        window.add(login_view.getPanel());
        window.show();
    }

}

