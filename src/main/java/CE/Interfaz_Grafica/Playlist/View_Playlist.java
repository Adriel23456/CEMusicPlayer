package CE.Interfaz_Grafica.Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Playlist implements Observer {
    private Controller_Playlist controller;
    private Model_Playlist model;
    private JLabel Usuario;
    private JButton crearButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JTextField Biblioteca;
    private JTable Bibliotecas;
    private JPanel panel;
    private JButton returnButton;

    public void Inicia(){
        Controller_Playlist.inicializacion();
    }

    public View_Playlist() {
        Inicia();
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
    }
    public void setController(Controller_Playlist controller) {this.controller = controller;}

    public void setModel(Model_Playlist model) {
        this.model = model;
        model.addObserver(this);
    }


    public JLabel getUsuario() {
        return Usuario;
    }

    public JButton getCrearButton() {
        return crearButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public JTextField getBiblioteca() {
        return Biblioteca;
    }

    public JTable getBibliotecas() {
        return Bibliotecas;
    }

    public JButton getReturnButton() {return returnButton;}

    public JPanel getPanel() {
        return panel;
    }
}
