package Vista;

import Controlador.ParametrosController;
import Vista.tables.PresentacionesTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPresentaciones extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton guardarButton;
    private JTextField txtDescuento;
    private JTextField txtDescripcion;
    private JTextField txtDescuentoHH;
    private JButton eliminarButton;
    private JTextField textField5;
    private JComboBox comboBox1;
    private ParametrosController PC;

    public FrmPresentaciones()
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
        table1.setModel(new PresentacionesTableModel(PC.getPresentacionesDTO()));
    }

    public void loadEvents()
    {
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               PC.crearPresentaciones(txtDescripcion.getText(), Integer.parseInt((String) comboBox1.getSelectedItem()), Float.parseFloat(txtDescuentoHH.getText()), Float.parseFloat(txtDescuento.getText()));
               cargarTabla();
            }
        });
    }
}
