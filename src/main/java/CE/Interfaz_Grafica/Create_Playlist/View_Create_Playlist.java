package CE.Interfaz_Grafica.Create_Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Create_Playlist implements Observer {
    private Controller_Create_Playlist controller;
    private Model_Create_Playlist model;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField NombreBiblioteca;
    private JPanel panel;

    public View_Create_Playlist() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    public void setController(Controller_Create_Playlist controller) {this.controller = controller;}

    public void setModel(Model_Create_Playlist model) {
        this.model = model;
        model.addObserver(this);
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JTextField getNombreBiblioteca() {
        return NombreBiblioteca;
    }

    public JPanel getPanel() {
        return panel;
    }
}
