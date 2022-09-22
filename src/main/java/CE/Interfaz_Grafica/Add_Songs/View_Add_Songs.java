package CE.Interfaz_Grafica.Add_Songs;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class View_Add_Songs implements Observer {
    private Controller_Add_Songs controller;
    private Model_Add_Songs model;
    private JTextField Buscador;
    private JTable Canciones;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panel;

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
    @Override
    public void update(Observable o, Object arg) {
    }

    public void setController(Controller_Add_Songs controller) {this.controller = controller;}

    public void setModel(Model_Add_Songs model) {
        this.model = model;
        model.addObserver(this);
    }

    public JTextField getBuscador() {
        return Buscador;
    }

    public JTable getCanciones() {
        return Canciones;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}
