package CE.Interfaz_Grafica.Songs;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.*;
import CE.Interfaz_Grafica.Playlist.View_Playlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

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
    private JTable Canciones;
    private JButton reproducirButton;
    private JButton pausarButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton masButton;
    private JButton menosButton;
    private JPanel panel;
    private JCheckBox reproduccionConstanteCheckBox;
    private JCheckBox cancionFavoritaCheckBox;
    private String reproduccionConstante = "OFF";
    private final boolean[] notselected = {TRUE};
    private Song Selected_song = new Song();
    int row = 0;
    int row2 = 0;
    public void Edit_Song(){
        controller.edit_song();
    }

    public Song getSelected_song() {
        return Selected_song;
    }

    public void setSelected_song(Song selected_song) {
        Selected_song = selected_song;
    }

    public View_Songs() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View_Playlist.playlistselected[0] == FALSE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una biblioteca");
                }
                else{
                    Add_Song();
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
                else{
                    controller.borrar(Selected_song);
                    notselected[0] = TRUE;
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
                else{
                    Application.edit_song_controller.getModel().setSelected_song(Selected_song);
                    Application.edit_song_controller.getModel().commit();
                    Edit_Song();
                    notselected[0] = TRUE;
                }
            }
        });
        cancionFavoritaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    cancionFavoritaCheckBox.setSelected(FALSE);
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
                else{
                    DoubleLinkedList<Song> favoritesongs = Application.playlist_controller.getModel().getUser().getFavoritesongs();
                    if (cancionFavoritaCheckBox.isSelected()){
                        favoritesongs.add(Selected_song);
                    }
                    else{
                        favoritesongs.remove(Service.instance().SongGet2(Selected_song));
                    }
                    notselected[0] = TRUE;
                }
            }
        });
        reproducirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
                else{
                    if (reproduccion[0] == Boolean.FALSE){
                        reproduccion3[0] = Boolean.TRUE;
                        Sound.stopMusic();
                    }
                    try {
                        if (playMusic1[0] == Boolean.TRUE){
                            //SE DEBE SELECCIONAR LA CANCION QUE LE DIMOS CLICK EN LA PARTE DE LA TABLA, TANTO COMO PARA SETFILE COMO PARA SETFILE 2
                            Sound.setFile(model.getListaSongs().getElement(getRow()).getMP3File());
                            reproduccion3[0] = Boolean.FALSE;
                            Sound.playMusic();
                        }
                        else{
                            //SE DEBE SELECCIONAR LA CANCION QUE LE DIMOS CLICK EN LA PARTE DE LA TABLA, TANTO COMO PARA SETFILE 2 COMO PARA SETFILE
                            Sound.setFile2(model.getListaSongs().getElement(getRow()).getMP3File());
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
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
                else{
                    if (cancionUNO[0] == Boolean.TRUE){
                        reproduccion2[0] = Boolean.TRUE;
                        Sound.stopMusic();
                        try {
                            if (playMusic1[0] == Boolean.TRUE){
                                reproduccion2[0] = Boolean.FALSE;
                                //ANTERIOR CANCIÓN
                                Sound.setFile(Sound.lastrow());
                                Sound.playMusic();
                            }
                            else{
                                //ANTERIOR CANCIÓN
                                Sound.setFile2(Sound.lastrow());
                                reproduccion2[0] = Boolean.FALSE;
                                Sound.playMusic2();
                            }
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        reproduccion[0] = Boolean.FALSE;
                    }
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
                            //SIGUIENTE CANCIÓN
                            Sound.setFile(Sound.nextrow());
                            Sound.playMusic();
                        }
                        else{
                            reproduccion2[0] = Boolean.FALSE;
                            //SIGUIENTE CANCIÓN
                            Sound.setFile(Sound.nextrow());
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
        Canciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                row = getCanciones().getSelectedRow();
                row2 = getCanciones().getSelectedRow() + 1;
                Selected_song = take(row);
                checkfavorite();
                notselected[0] = FALSE;
            }
        });
    }

    public void checkfavorite(){
        DoubleLinkedList<Song> favoritesongs = Application.playlist_controller.getModel().getUser().getFavoritesongs();
        for (int i = 0;i<favoritesongs.getNumberOfElements();i++){
            if (Selected_song.getName().equals(favoritesongs.getElement(i).getName())){
                cancionFavoritaCheckBox.setSelected(TRUE);
                return;
            }
        }
        cancionFavoritaCheckBox.setSelected(FALSE);
    }
    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {CE.Interfaz_Grafica.Songs.Table_Model.NOMBRE, CE.Interfaz_Grafica.Songs.Table_Model.ARTISTA, CE.Interfaz_Grafica.Songs.Table_Model.ALBUM};
        Canciones.setModel(new CE.Interfaz_Grafica.Songs.Table_Model(model.getPlaylist().getSongs(), cols));
        Canciones.setRowHeight(25);
        this.panel.revalidate();
    }

    public void Add_Song(){
        controller.add_song();
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
    public JCheckBox getReproduccionConstanteCheckBox() {
        return reproduccionConstanteCheckBox;
    }
    public JCheckBox getCancionFavoritaCheckBox() {
        return cancionFavoritaCheckBox;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow2() {
        return row2;
    }

    public void setRow2(int row2) {
        this.row2 = row2;
    }

    public Song take(int row){
        String code = model.getListaSongs().getElement(row).getName();
        Song e = null;
        try{
            e = Service.instance().SongGet(code, Application.add_songs_controller.getModel().getListaSongsOficial());
        }catch (Exception ex){}
        return e;
    }
}
