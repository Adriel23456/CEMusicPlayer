package Clases_De_Interfaz_Grafica.Edit_Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Edit_Song {
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JLabel Label;
    private JTextField Genero;
    private JTextField Artista;
    private JTextField Album;
    private JTextField Ano;
    private JTextArea Letra;
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
}
