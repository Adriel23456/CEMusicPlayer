package Clases_De_Interfaz_Grafica.Add_Songs;

import javax.swing.*;
import java.awt.event.*;

public class View_Add_Songs {
    private JTextField Buscador;
    private JTable Canciones;
    private JButton aceptarButton;
    private JButton cancelarButton;

    public View_Add_Songs() {
        Buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        Canciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
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
