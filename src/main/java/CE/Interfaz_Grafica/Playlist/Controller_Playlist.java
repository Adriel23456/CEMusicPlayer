package CE.Interfaz_Grafica.Playlist;

public class Controller_Playlist {

    View_Playlist view;
    Model_Playlist model;

    public Controller_Playlist(View_Playlist view, Model_Playlist model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public static void inicializacion(){
        return;
        //TODA LA LOGICA DE LA APERTURA DEL POP UP
    }

    public View_Playlist getView() {
        return view;
    }
}
