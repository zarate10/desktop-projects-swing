package Vista;

import Controlador.ParametrosController;
import Vista.tables.MesasTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMesas extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JButton eliminarButton;
    private JButton guardarButton;
    private JTextField textField2;
    private ParametrosController PC;

    public FrmMesas()
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
        table1.setModel(new MesasTableModel(PC.getMesasDTO()));
    }
    private void loadEvents()
    {
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PC.crearMesas(textField2.getText());
                cargarTabla();
            }
        });
    }
}
