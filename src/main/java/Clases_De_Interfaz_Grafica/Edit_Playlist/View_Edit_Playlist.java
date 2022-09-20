package Clases_De_Interfaz_Grafica.Edit_Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class View_Edit_Playlist {
    private JLabel Biblioteca;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField NewBiblioteca;


    public View_Edit_Playlist() {
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
