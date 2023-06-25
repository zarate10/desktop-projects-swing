package Vista;

import Controlador.ParametrosController;
import Vista.tables.TarjetasTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;

public class FrmTarjetas extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField txtNombreTarjeta;
    private JTextField txtDescuentoTarjeta;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JTextField textFieldDeleteID;
    private ParametrosController PC;

    public FrmTarjetas()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
        PC = ParametrosController.getInstance();
        table1.setModel(new TarjetasTableModel(PC.getTarjetasDTO()));
    }
}
