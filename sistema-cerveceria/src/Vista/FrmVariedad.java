package Vista;

import Controlador.ParametrosController;
import Vista.tables.VariedadTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVariedad extends JInternalFrame {
    private JPanel panel1;
    private JTable tableCervezas;
    private JComboBox comboBoxTipoCerveza;
    private JButton eliminarButton;
    private JTextField textFieldDeleteID;
    private JTextField txtPrecioLt;
    private JTextField txtDescripcion;
    private JButton guardarButton;
    private ParametrosController PC;

    public FrmVariedad()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
        PC = ParametrosController.getInstance();

        cargarTabla();
        loadEvents();
    }

    private void cargarTabla()
    {
        tableCervezas.setModel(new VariedadTableModel(PC.getVariedadesDTO()));
    }

    private void loadEvents()
    {
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PC.crearVariedades(txtDescripcion.getText(), Float.parseFloat(txtPrecioLt.getText()), (String) comboBoxTipoCerveza.getSelectedItem());
                cargarTabla();
            }
        });
    }
}
