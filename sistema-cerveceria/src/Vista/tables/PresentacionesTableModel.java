package Vista.tables;

import DTO.PresentacionDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PresentacionesTableModel extends AbstractTableModel {
    /* Lista con los tipos de datos DTO */
    List<PresentacionDTO> datos;
    /* Acá van los nombres de las columnas */
    protected String[] columnNames = new String[] { "ID", "Descripción", "Cantidad CC.", "Descuento", "Descuento HH" };
    /* Tipo de dato de cada columna seguido de un .class */
    protected Class[] columnClasses = new Class[] { int.class, String.class, int.class, float.class, float.class };
    /* Método constructor del TableModel */
    public PresentacionesTableModel(List<PresentacionDTO> datos) { this.datos = datos; }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return datos.get(rowIndex).presentacionID;
            case 1: return datos.get(rowIndex).descripcion;
            case 2: return datos.get(rowIndex).cantidadCC;
            case 3: return datos.get(rowIndex).descuentoGeneral;
            case 4: return datos.get(rowIndex).descuentoHH;
            default: return null;
        }
    }
    /* NO TOCAR */
    public String getColumnName(int col) { return columnNames[col]; }
    public Class getColumnClass(int col) { return columnClasses[col]; }
    public int getColumnCount() { return columnNames.length; }
    public int getRowCount() { return datos.size(); }
    public boolean isCellEditable(int row, int column){ return false; }
    public void refresh() { fireTableDataChanged(); }
}