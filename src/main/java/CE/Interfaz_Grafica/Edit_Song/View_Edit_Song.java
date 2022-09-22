package CE.Interfaz_Grafica.Edit_Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Edit_Song implements Observer {
    private Controller_Edit_Song controller;
    private Model_Edit_Song model;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel Label;
    private JTextField Genero;
    private JTextField Artista;
    private JTextField Album;
    private JTextField Ano;
    private JTextArea Letra;
    private JPanel panel;

    public View_Edit_Song() {
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

    public void setController(Controller_Edit_Song controller) {this.controller = controller;}

    public void setModel(Model_Edit_Song model) {
        this.model = model;
        model.addObserver(this);
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public JLabel getLabel() {
        return Label;
    }

    public JTextField getGenero() {
        return Genero;
    }

    public JTextField getArtista() {
        return Artista;
    }

    public JTextField getAlbum() {
        return Album;
    }

    public JTextField getAno() {
        return Ano;
    }

    public JTextArea getLetra() {
        return Letra;
    }

    public JPanel getPanel() {
        return panel;
    }
}
