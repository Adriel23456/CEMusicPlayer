package CE.Interfaz_Grafica.Playlist;

import CE.Clases_De_Estructuras_De_Datos.DoubleLinkedList;
import CE.Clases_Principales.Playlist;
import javax.swing.table.AbstractTableModel;

public class Table_Model extends AbstractTableModel {
    DoubleLinkedList<Playlist> rows;
    int [] cols;

    public Table_Model(DoubleLinkedList<Playlist> rows, int[] cols) {
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
        Playlist playlist = rows.getElement(rowIndex);
        switch (cols[columnIndex]){
            case NOMBRE: return playlist.getName();
            case NUMERODECANCIONES: return playlist.getSongs().getNumberOfElements();
            case FECHA: return playlist.getFecha();
            default: return "";
        }
    }
    public static final int NOMBRE = 0;
    public static final int NUMERODECANCIONES = 1;
    public static final int FECHA = 2;
    String [] colNames = new String [3];
    private void initColNames(){
        colNames[NOMBRE] = "Nombre";
        colNames[NUMERODECANCIONES] = "Numero de canciones";
        colNames[FECHA] = "Fecha";
    }
}
