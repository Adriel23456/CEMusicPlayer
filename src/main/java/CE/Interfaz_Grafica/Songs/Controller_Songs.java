package CE.Interfaz_Grafica.Songs;

import CE.Application;
import CE.Interfaz_Grafica.Add_Songs.Controller_Add_Songs;
import CE.Interfaz_Grafica.Edit_Song.Controller_Edit_Song;

public class Controller_Songs {
    Controller_Edit_Song controller_edit_song;
    Controller_Add_Songs controller_add_songs;
    View_Songs view;
    Model_Songs model;

    public Controller_Songs(View_Songs view, Model_Songs model, Controller_Edit_Song controller_edit_song, Controller_Add_Songs controller_add_songs) {
        this.view = view;
        this.model = model;
        this.controller_edit_song = controller_edit_song;
        this.controller_add_songs = controller_add_songs;
        view.setController(this);
        view.setModel(model);
    }
    /*
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
    */
    public void add_song(){
        Application.add_songs_controller.show();
    }

    public void edit_song(){
        Application.edit_song_controller.show();
    }

    public View_Songs getView() {
        return view;
    }

    public void setView(View_Songs view) {
        this.view = view;
    }

    public Model_Songs getModel() {
        return model;
    }

    public void setModel(Model_Songs model) {
        this.model = model;
    }
}
