package Clases_De_Interfaz_Grafica.Create_Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View_Create_Playlist {
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField NombreBiblioteca;

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
}
