package CE.Interfaz_Grafica.Songs;

import CE.Clases_Principales.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Songs implements Observer {
    public static final Boolean[] reproduccion = {Boolean.TRUE};
    public static final Boolean[] reproduccion2 = {Boolean.TRUE};
    public static final Boolean[] reproduccion3 = {Boolean.FALSE};
    public static final Boolean[] Allowvolume = {Boolean.FALSE};
    public static final Boolean[] playMusic1 = {Boolean.TRUE};

    public static final Boolean[] cancionUNO = {Boolean.FALSE};
    private Controller_Songs controller;
    private Model_Songs model;
    private JLabel Nombre_Biblioteca;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JTextField Buscador;
    private JTable Canciones;
    private JButton reproducirButton;
    private JButton pausarButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton masButton;
    private JButton menosButton;
    private JPanel panel;
    private JButton returnButton;
    private JCheckBox reproduccionConstanteCheckBox;
    private JCheckBox cancionFavoritaCheckBox;
    private String reproduccionConstante = "OFF";
    private String cancionFavorita = "OFF";

    public void Add_Song(){
        controller.add_song();
    }

    public void Edit_Song(){
        controller.edit_song();
    }

    public View_Songs() {


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Song();
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
                Edit_Song();
            }
        });
        cancionFavoritaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reproducirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproduccion[0] == Boolean.FALSE){
                    reproduccion3[0] = Boolean.TRUE;
                    Sound.stopMusic();
                }
                try {
                    if (playMusic1[0] == Boolean.TRUE){
                        //SE DEBE SELECCIONAR LA CANCION QUE LE DIMOS CLICK EN LA PARTE DE LA TABLA, TANTO COMO PARA SETFILE COMO PARA SETFILE 2
                        Sound.setFile("Canciones/As it was.wav");
                        reproduccion3[0] = Boolean.FALSE;
                        Sound.playMusic();
                    }
                    else{
                        //SE DEBE SELECCIONAR LA CANCION QUE LE DIMOS CLICK EN LA PARTE DE LA TABLA, TANTO COMO PARA SETFILE COMO PARA SETFILE 2
                        Sound.setFile2("Canciones/MIRÁ MAMÁ.wav");
                        reproduccion3[0] = Boolean.FALSE;
                        Sound.playMusic2();
                    }
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Allowvolume[0] = Boolean.TRUE;
                cancionUNO[0] = Boolean.TRUE;
                reproduccion[0] = Boolean.FALSE;
                reproduccion2[0] = Boolean.FALSE;
            }
        });
        pausarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproduccion[0] == Boolean.FALSE){
                    reproduccion[0] = Boolean.TRUE;
                    Sound.pauseMusic();
                }
            }
        });
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cancionUNO[0] == Boolean.TRUE){
                    reproduccion2[0] = Boolean.TRUE;
                    Sound.stopMusic();
                    try {
                        if (playMusic1[0] == Boolean.TRUE){
                            reproduccion2[0] = Boolean.FALSE;
                            Sound.setFile("Canciones/Latch.wav");
                            Sound.playMusic();
                        }
                        else{
                            Sound.setFile2("Canciones/Latch.wav");
                            reproduccion2[0] = Boolean.FALSE;
                            Sound.playMusic2();
                        }
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    reproduccion[0] = Boolean.FALSE;
                }
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cancionUNO[0] == Boolean.TRUE){
                    reproduccion2[0] = Boolean.TRUE;
                    Sound.stopMusic();
                    try {
                        if (playMusic1[0] == Boolean.TRUE){
                            reproduccion2[0] = Boolean.FALSE;
                            Sound.setFile("Canciones/The Spins.wav");
                            Sound.playMusic();
                        }
                        else{
                            reproduccion2[0] = Boolean.FALSE;
                            Sound.setFile2("Canciones/The Spins.wav");
                            Sound.playMusic2();
                        }
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    reproduccion[0] = Boolean.FALSE;
                }
            }
        });
        masButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Allowvolume[0] == Boolean.TRUE){
                    Sound.volumeUp();
                }
                else{
                    System.out.println("No se ha seleccionado una canción aun");
                }
            }
        });
        menosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Allowvolume[0] == Boolean.TRUE){
                    Sound.volumeDown();
                }
                else{
                    System.out.println("No se ha seleccionado una canción aun");
                }
            }
        });

        reproduccionConstanteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproduccionConstanteCheckBox.isSelected()){
                    reproduccionConstante = "ON";
                }
                else{
                    reproduccionConstante = "OFF";
                }
                if (reproduccionConstante == "OFF"){
                    if (cancionUNO[0] == Boolean.TRUE){
                        Sound.NOloopMusic();
                    }
                } else if (reproduccionConstante == "ON") {
                    if (cancionUNO[0] == Boolean.TRUE){
                        Sound.loopMusic();
                    }
                }
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

    public JPanel getPanel() {
        return panel;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JCheckBox getReproduccionConstanteCheckBox() {
        return reproduccionConstanteCheckBox;
    }

    public JCheckBox getCancionFavoritaCheckBox() {
        return cancionFavoritaCheckBox;
    }
}
