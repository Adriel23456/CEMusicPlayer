package CE.Interfaz_Grafica.Edit_Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
                controller.edit(Label.getText(),Genero.getText(),Artista.getText(),Album.getText(),Ano.getText(),Letra.getText());
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
        Label.setText(model.selected_song.getName());
        Genero.setText(model.selected_song.getGenre());
        Artista.setText(model.selected_song.getArtist());
        Album.setText(model.selected_song.getAlbum());
        Ano.setText(model.selected_song.getYear());
        Letra.setText(model.selected_song.getLyrics());
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
