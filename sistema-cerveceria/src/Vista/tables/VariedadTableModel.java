package Vista.tables;

import DTO.VariedadDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VariedadTableModel extends AbstractTableModel {
    List<VariedadDTO> datos;

    protected String[] columnNames = new String[] { "ID", "Descripción", "Precio Lt.", "Tipo Cerveza" };
    protected Class[] columnClasses = new Class[] { int.class, String.class, float.class, String.class };

    public VariedadTableModel(List<VariedadDTO> datos)
    {
        this.datos = datos;
    }

    public String getColumnName(int col) { return columnNames[col]; }
    public Class getColumnClass(int col) { return columnClasses[col]; }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return datos.size();
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return datos.get(rowIndex).ID;
            case 1: return datos.get(rowIndex).descripcion;
            case 2: return datos.get(rowIndex).precioLt;
            case 3: return datos.get(rowIndex).tipo;
            default: return null;
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }
}
