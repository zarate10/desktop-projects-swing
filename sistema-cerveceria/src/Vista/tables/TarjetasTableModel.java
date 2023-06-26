package Vista.tables;

import DTO.TarjetaDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TarjetasTableModel extends AbstractTableModel {
    List<TarjetaDTO> datos;

    protected String[] columnNames = new String[] { "Tipo tarjeta", "Descuento" };
    protected Class[] columnClasses = new Class[] { String.class, float.class };

    public TarjetasTableModel(List<TarjetaDTO> datos)
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
            case 0: return datos.get(rowIndex).tipoTarjeta;
            case 1: return datos.get(rowIndex).descuento;
            default: return null;
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }
}
