package CE.Interfaz_Grafica.Playlist;

import CE.Application;
import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.Playlist;
import CE.Clases_Principales.Service;
import CE.Clases_Principales.User;
import CE.Interfaz_Grafica.Create_Playlist.Controller_Create_Playlist;
import CE.Interfaz_Grafica.Edit_Playlist.Controller_Edit_Playlist;
import CE.Interfaz_Grafica.Login.View_Login;

public class Controller_Playlist {

    Controller_Edit_Playlist controller_edit_playlist;
    Controller_Create_Playlist controller_create_playlist;
    View_Playlist view;
    Model_Playlist model;

    /**
     * Se establece el desarrollo de la ventana autenticación
     */
    View_Login view_login = new View_Login();

    public Controller_Playlist(View_Playlist view, Model_Playlist model, Controller_Edit_Playlist controller_edit_playlist, Controller_Create_Playlist controller_create_playlist) {
        //model.setLista(Service.instance().playlistSearch(""));
        this.view = view;
        this.model = model;
        this.controller_edit_playlist = controller_edit_playlist;
        this.controller_create_playlist = controller_create_playlist;
        view.setController(this);
        view.setModel(model);
    }
    public void buscar(String filtro){
        DoubleLinkedList<Playlist> rows = Service.instance().playlistSearch(filtro);
        System.out.println(rows.getNumberOfElements());
        model.setLista(rows);
        System.out.println(model.getLista().getNumberOfElements());
        model.commit();
    }
    public void edit(int row){
        String code = model.getUser().getPlaylists().getElement(row).getName();
        Playlist e = null;
        try{
            e = Service.instance().PlaylistGet(code, model.getUser());
            Application.edit_playlist_controller.edit(e);
            model.commit();
        }catch (Exception ex){}
    }
    public void borrar(User user, int row){
        String code = model.getUser().getPlaylists().getElement(row).getName();
        Playlist e = null;
        try{
            e = Service.instance().PlaylistGet(code, model.getUser());
            Service.instance().removePlaylist(e,user);
            buscar("");

        }catch (Exception ex){}
    }
    public void playlistclick(int row){
        String code = model.getUser().getPlaylists().getElement(row).getName();
        Playlist e = null;
        try{
            e = Service.instance().PlaylistGet(code, model.getUser());
            Service.instance().loadPlaylist(e);
            Application.songs_controller.getModel().commit();
        }catch (Exception ex){}
    }
    public void log_out(){
        Application.login_controller.show();
    }
    public void create_playlist(){
        Application.create_playlist_controller.show();
    }
    public View_Playlist getView() {
        return view;
    }
    public void setView(View_Playlist view) {this.view = view;}
    public void setModel(Model_Playlist model) {
        this.model = model;
    }
    public Model_Playlist getModel() {
        return model;
    }

}
