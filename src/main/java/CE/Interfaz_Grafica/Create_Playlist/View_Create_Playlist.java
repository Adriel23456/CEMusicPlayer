package CE.Interfaz_Grafica.Create_Playlist;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Song;

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
                Playlist playlist = take();
                controller.addplaylist(playlist);
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
    }

    public void setController(Controller_Create_Playlist controller) {this.controller = controller;}

    public void setModel(Model_Create_Playlist model) {
        this.model = model;
        model.addObserver(this);
    }

    public Playlist take(){
        return new Playlist(new DoubleCircledLinkedList<Song>(),getNombreBiblioteca().getText().toString(),"");
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
