package Vista;

import Controlador.ParametrosController;
import Vista.tables.TarjetasTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        cargarTabla();
        loadEvents();
    }

    private void cargarTabla()
    {
        table1.setModel(new TarjetasTableModel(PC.getTarjetasDTO()));
    }

    private void loadEvents()
    {
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PC.crearTarjetas(txtNombreTarjeta.getText(), Float.parseFloat(txtDescuentoTarjeta.getText()));
                cargarTabla();
            }
        });
    }
}
