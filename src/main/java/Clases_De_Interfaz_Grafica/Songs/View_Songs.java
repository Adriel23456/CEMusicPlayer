package Clases_De_Interfaz_Grafica.Songs;

import Clases_Principales.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Songs implements Observer {
    private Controller_Songs controller;
    private Model_Songs model;
    private JLabel Nombre_Biblioteca;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JRadioButton favoritoRadioButton;
    private JTextField Buscador;
    private JTable Canciones;
    private JButton reproducirButton;
    private JButton pausarButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton masButton;
    private JButton menosButton;
    private JRadioButton reproduccionConstanteRadioButton;
    private JPanel panel;
    private JButton returnButton;


    public View_Songs() {

        final Boolean[] reproduccion = {Boolean.TRUE};


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        favoritoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reproducirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproduccion[0] == Boolean.TRUE){
                    String filepath = "Canciones/As it was.wav";
                    Sound.playMusic(filepath);
                    reproduccion[0] = Boolean.FALSE;
                }
            }
        });
        pausarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproduccion[0] == Boolean.FALSE){
                    String filepath = "Canciones/As it was.wav";
                    Sound.pauseMusic();
                    reproduccion[0] = Boolean.TRUE;
                }
            }
        });
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        masButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reproduccionConstanteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    public void setController(Controller_Songs controller) {this.controller = controller;}

    public void setModel(Model_Songs model) {
        this.model = model;
        model.addObserver(this);
    }

    public JLabel getNombre_Biblioteca() {
        return Nombre_Biblioteca;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public JRadioButton getFavoritoRadioButton() {
        return favoritoRadioButton;
    }

    public JTextField getBuscador() {
        return Buscador;
    }

    public JTable getCanciones() {
        return Canciones;
    }

    public JButton getReproducirButton() {
        return reproducirButton;
    }

    public JButton getPausarButton() {
        return pausarButton;
    }

    public JButton getAnteriorButton() {
        return anteriorButton;
    }

    public JButton getSiguienteButton() {
        return siguienteButton;
    }

    public JButton getMasButton() {
        return masButton;
    }

    public JButton getMenosButton() {
        return menosButton;
    }

    public JRadioButton getReproduccionConstanteRadioButton() {
        return reproduccionConstanteRadioButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
