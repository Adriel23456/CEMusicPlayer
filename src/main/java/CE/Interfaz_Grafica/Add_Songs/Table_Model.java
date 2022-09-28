package CE.Interfaz_Grafica.Add_Songs;

import CE.Clases_De_Estructuras_De_Datos.DoubleCircledLinkedList;
import CE.Clases_Principales.Song;

import javax.swing.table.AbstractTableModel;

public class Table_Model extends AbstractTableModel {
    DoubleCircledLinkedList<Song> rows;
    int [] cols;

    public Table_Model(DoubleCircledLinkedList<Song> rows, int[] cols) {
        initColNames();
        this.rows = rows;
        this.cols = cols;
    }
    public int getRowCount() {return rows.getNumberOfElements();}

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }
    }

    public int getColumnCount() {return cols.length;}


    public Object getValueAt(int rowIndex, int columnIndex) {
        Song song = rows.getElement(rowIndex);
        switch (cols[columnIndex]){
            case NOMBRE: return song.getName();
            case ARTISTA: return song.getArtist();
            case ALBUM: return song.getAlbum();
            default: return "";
        }
    }
    public static final int NOMBRE = 0;
    public static final int ARTISTA = 1;
    public static final int ALBUM = 2;
    String [] colNames = new String [3];
    private void initColNames(){
        colNames[NOMBRE] = "Nombre";
        colNames[ARTISTA] = "Artista";
        colNames[ALBUM] = "Album";
    }
}
