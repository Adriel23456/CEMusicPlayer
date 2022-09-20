package Clases_De_Interfaz_Grafica.Login;

import Clases_De_Interfaz_Grafica.Songs.Controller_Songs;
import Clases_Principales.CEMusicPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase creada utilizando el sistema de creación de ventanas de IntelliJ
 */
public class View_Login implements Observer {
    private Controller_Login controller;
    private Model_Login model;
    private JButton iniciarsesionButton;
    private JTextField Correo_iniciosesion;
    private JTextField Contraseña_iniciosesion;
    private JButton registrateButton;
    private JTextField Usuario;
    private JTextField Correo;
    private JTextField Contraseña;
    private JComboBox Provincia;
    private JPanel panel;

    public View_Login() {
        iniciarsesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate2() == false){
                    JOptionPane.showMessageDialog(panel, "Favor complete todos los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (validate2() == true && (controller.loginUser() == false)){
                    JOptionPane.showMessageDialog(panel, "Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate() == false){
                    JOptionPane.showMessageDialog(panel, "Favor complete todos los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                if (validate() == true && (controller.addUser() == false)){
                    JOptionPane.showMessageDialog(panel, "Usuario ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validate() {
        if (Usuario.getText().isEmpty()) {
            return false;
        }
        if (Correo.getText().isEmpty()) {
            return false;
        }
        if (Contraseña.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validate2() {
        if (Correo_iniciosesion.getText().isEmpty()) {
            return false;
        }
        if (Contraseña_iniciosesion.getText().isEmpty()) {
            return false;
        }
        return true;
    }


    @Override
    public void update(Observable o, Object arg) {
    }
    public void setController(Controller_Login controller) {this.controller = controller;}

    public void setModel(Model_Login model) {
        this.model = model;
        model.addObserver(this);
    }

    public JTextField getCorreo_iniciosesion() {
        return Correo_iniciosesion;
    }

    public JTextField getContraseña_iniciosesion() {
        return Contraseña_iniciosesion;
    }

    public JTextField getUsuario() {
        return Usuario;
    }

    public JTextField getCorreo() {
        return Correo;
    }

    public JTextField getContraseña() {
        return Contraseña;
    }

    public JComboBox getProvincia() {
        return Provincia;
    }

    public JPanel getPanel() {
        return panel;
    }
}
