import Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import Clases_De_Interfaz_Grafica.Songs.Controller_Songs;
import Clases_Principales.CEMusicPlayer;
import Clases_Principales.Song;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.text.FieldPosition;
import java.util.List;
import java.util.Scanner;

/**
 * @author Adriel
 */
public class Application {
    /**
     * Se establecen los atributos de los controllers de todas las ventanas, fuera del método main para llamarlos en cualquier situación
     */
    public static JFrame window;
    public static Clases_De_Interfaz_Grafica.Login.Controller_Login login_controller;

    static Scanner scanner = new Scanner(System.in);   //Scanner object to read user input
    InputStream input;

    /**
     * Se establece la clase main, la cual inicia el programa con la iniciación de la ventana Login
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, LineUnavailableException {

        try{
            File file = new File("Canciones.xml");
            if (file.exists()){
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse("Canciones.xml");
                NodeList list = doc.getChildNodes();
                CreateSongsList (list);
            }

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e){}

        Clases_De_Interfaz_Grafica.Login.Model_Login login_model = new Clases_De_Interfaz_Grafica.Login.Model_Login();
        Clases_De_Interfaz_Grafica.Login.View_Login login_view = new Clases_De_Interfaz_Grafica.Login.View_Login();
        login_controller = new Clases_De_Interfaz_Grafica.Login.Controller_Login(login_view,login_model);

        window = new JFrame();
        window.setSize(500,550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISTEMA...");
        window.setVisible(true);
        window.add(login_view.getPanel());
        window.show();
    }

    private static void CreateSongsList(NodeList nlist) {
        for (int i=0;i<nlist.getLength();i++){
            Node node = nlist.item(i);
            if (node.hasChildNodes()){
                if (node.getChildNodes().getLength()==1){
                    //"Guardar en un array la informacion mostrada ;v"
                    System.out.println(node.getTextContent());
                }
                CreateSongsList(node.getChildNodes());
            }
        }
    }
}