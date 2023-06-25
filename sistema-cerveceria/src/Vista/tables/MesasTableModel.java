package Vista.tables;

import DTO.MesaDTO;
import DTO.PresentacionDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MesasTableModel extends AbstractTableModel {
    /* Lista con los tipos de datos DTO */
    List<MesaDTO> datos;
    /* Acá van los nombres de las columnas */
    protected String[] columnNames = new String[] { "ID", "Descripción" };
    /* Tipo de dato de cada columna seguido de un .class */
    protected Class[] columnClasses = new Class[] { int.class, String.class };
    /* Método constructor del TableModel */
    public MesasTableModel(List<MesaDTO> datos) { this.datos = datos; }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return datos.get(rowIndex).mesaID;
            case 1: return datos.get(rowIndex).descripcion;
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