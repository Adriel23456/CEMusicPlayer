package CE.Interfaz_Grafica.Playlist;

import CE.Application;
import CE.Clases_Principales.User;
import CE.Interfaz_Grafica.Songs.View_Songs;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class View_Playlist implements Observer {
    private Controller_Playlist controller;
    private Model_Playlist model;
    private JLabel Usuario;
    private JButton crearButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JTable Bibliotecas;
    private JPanel panel;
    private JButton loginAnotherButton;
    private JButton seleccionarButton;
    private static boolean[] notselected = {TRUE};
    public static boolean[] playlistselected = {FALSE};
    public void Log_out(){controller.log_out();}
    public void Create_Playlist(){
        controller.create_playlist();
    }

    public View_Playlist() {
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create_Playlist();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una biblioteca");
                }
                else{
                    User user = model.getUser();
                    int row = getBibliotecas().getSelectedRow();
                    controller.borrar(user, row);
                    notselected[0] = TRUE;
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una biblioteca");
                }
                else{
                    int row = getBibliotecas().getSelectedRow();
                    controller.edit(row);
                    notselected[0] = TRUE;
                }
            }
        });
        loginAnotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log_out();
            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notselected[0] == TRUE){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar una biblioteca");
                }
                else{
                    int row = getBibliotecas().getSelectedRow();
                    controller.playlistclick(row);
                    Application.songs_controller.getView().getCancionFavoritaCheckBox().setSelected(FALSE);
                    playlistselected[0] = TRUE;
                    notselected[0] = TRUE;
                }
            }
        });
        Bibliotecas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                notselected[0] = FALSE;
            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {Table_Model.NOMBRE,Table_Model.NUMERODECANCIONES,Table_Model.FECHA};
        Bibliotecas.setModel(new CE.Interfaz_Grafica.Playlist.Table_Model(model.getUser().getPlaylists(), cols));
        Bibliotecas.setRowHeight(25);
        Usuario.setText(model.getUser().getName());
        this.panel.revalidate();
    }
    public void setController(Controller_Playlist controller) {
        this.controller = controller;
    }
    public void setModel(Model_Playlist model) {
        this.model = model;
        model.addObserver(this);
    }
    public JLabel getUsuario() {
        return Usuario;
    }

    public JButton getCrearButton() {
        return crearButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public JTable getBibliotecas() {
        return Bibliotecas;
    }

    public JButton getLoginAnotherButton() {
        return loginAnotherButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}
