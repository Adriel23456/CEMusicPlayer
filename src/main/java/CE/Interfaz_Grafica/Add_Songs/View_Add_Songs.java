package CE.Interfaz_Grafica.Add_Songs;

import CE.Application;
import CE.Clases_Principales.*;

import javax.swing.*;
import java.awt.event.*;
import java.security.KeyStore;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class View_Add_Songs implements Observer {
    private Controller_Add_Songs controller;
    private Model_Add_Songs model;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panel;
    private JTable Canciones;
    private final boolean[] notselected = {TRUE};

    public View_Add_Songs() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = getCanciones().getSelectedRow();
                if (notselected[0] == FALSE){
                    Song song = take(row);
                    controller.addSong(song);
                    controller.hide();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una canción");
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hide();
            }
        });

        Canciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                notselected[0] = FALSE;
            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {CE.Interfaz_Grafica.Add_Songs.Table_Model.NOMBRE, CE.Interfaz_Grafica.Add_Songs.Table_Model.ARTISTA, CE.Interfaz_Grafica.Add_Songs.Table_Model.ALBUM};
        Canciones.setModel(new CE.Interfaz_Grafica.Add_Songs.Table_Model(model.getListaSongsOficial(), cols));
        Canciones.setRowHeight(25);
        this.panel.revalidate();
    }
    public void setController(Controller_Add_Songs controller) {this.controller = controller;}
    public void setModel(Model_Add_Songs model) {
        this.model = model;
        model.addObserver(this);
    }
    public JButton getAceptarButton() {return aceptarButton;}
    public JButton getCancelarButton() {return cancelarButton;}
    public JPanel getPanel() {return panel;}
    public JTable getCanciones() {return Canciones;}
    public void setCanciones(JTable canciones) {Canciones = canciones;}
    public Song take(int row){
        String code = model.getListaSongsOficial().getElement(row).getName();
        Song e = null;
        try{
            e = Service.instance().SongGet(code, Application.add_songs_controller.getModel().getListaSongsOficial());
        }catch (Exception ex){}
        return e;
    }
}
