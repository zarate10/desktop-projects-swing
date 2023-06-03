package models;

import DTO.ReservaDTO;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

public class TableModel extends AbstractTableModel {

    List<ReservaDTO> datos;

    protected String[] columnNames = new String[] { "Doc. Resp.", "F. Salida", "F. Llegada", "N° Hab.", "Precio" };
    protected Class[] columnClasses = new Class[] { int.class, Date.class, Date.class, int.class, double.class };

    public String getColumnName(int col) { return columnNames[col]; }
    public Class getColumnClass(int col) { return columnClasses[col]; }

    public TableModel(List<ReservaDTO> datos)
    {
        this.datos = datos;
    }

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
            case 0: return datos.get(rowIndex).documentoResp;
            case 1: return datos.get(rowIndex).fechaLlegada;
            case 2: return datos.get(rowIndex).fechaSalida;
            case 3: return datos.get(rowIndex).numHabitacion;
            case 4: return datos.get(rowIndex).precio;
            default: return null;
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }
}
