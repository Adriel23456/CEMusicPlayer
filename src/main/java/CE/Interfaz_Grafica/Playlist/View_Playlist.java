package CE.Interfaz_Grafica.Playlist;

import CE.Clases_Principales.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Playlist implements Observer {
    private Controller_Playlist controller;
    private Model_Playlist model;
    private JLabel Usuario;
    private JButton crearButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JTextField Biblioteca;
    private JTable Bibliotecas;
    private JPanel panel;
    private JButton loginAnotherButton;
    private JButton seleccionarButton;
    private JButton buscarButton;

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
                User user = model.getUser();
                int row = getBibliotecas().getSelectedRow();
                controller.borrar(user, row);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = getBibliotecas().getSelectedRow();
                controller.edit(row);
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
                int row = getBibliotecas().getSelectedRow();
                controller.playlistclick(row);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.buscar(Biblioteca.getText());
            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {Table_Model.NOMBRE,Table_Model.NUMERODECANCIONES,Table_Model.FECHA};
        Bibliotecas.setModel(new CE.Interfaz_Grafica.Playlist.Table_Model(model.getUser().getPlaylists(), cols));
        Bibliotecas.setRowHeight(25);
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

    public JTextField getBiblioteca() {
        return Biblioteca;
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
