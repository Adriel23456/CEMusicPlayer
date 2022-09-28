package CE.Interfaz_Grafica.Edit_Playlist;

import CE.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Edit_Playlist implements Observer {
    private Controller_Edit_Playlist controller;
    private Model_Edit_Playlist model;
    private JLabel Biblioteca;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField NewBiblioteca;
    private JPanel panel;


    public View_Edit_Playlist() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hide();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hide();
            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
        Biblioteca.setText(controller.nombre_playlist);
    }

    public void setController(Controller_Edit_Playlist controller) {this.controller = controller;}

    public void setModel(Model_Edit_Playlist model) {
        this.model = model;
        model.addObserver(this);
    }

    public JLabel getBiblioteca() {return Biblioteca;}

    public void setBiblioteca(JLabel biblioteca) {Biblioteca = biblioteca;}

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JTextField getNewBiblioteca() {
        return NewBiblioteca;
    }

    public JPanel getPanel() {
        return panel;
    }
}
