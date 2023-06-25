package Vista;

import Controlador.ParametrosController;
import Vista.tables.VariedadTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;

public class FrmVariedad extends JInternalFrame {
    private JPanel panel1;
    private JTable tableCervezas;
    private JComboBox comboBoxTipoCerveza;
    private JButton eliminarButton;
    private JTextField textFieldDeleteID;
    private JTextField textField1;
    private JTextField textField2;
    private JButton guardarButton;
    private ParametrosController PC;

    public FrmVariedad()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
        PC = ParametrosController.getInstance();
        tableCervezas.setModel(new VariedadTableModel(PC.getVariedadesDTO()));
    }
}
