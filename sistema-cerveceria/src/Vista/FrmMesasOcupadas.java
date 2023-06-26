package Vista;

import Controlador.VentasController;
import DTO.MesaDTO;
import Vista.tables.MesasTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmMesasOcupadas extends JInternalFrame {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton cargarMesaButton;
    private JTable table1;
    private VentasController VC;

    public FrmMesasOcupadas()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
        VC = VentasController.getInstance();

        updateCombo(comboBox1);
        cargarTabla();
        loadEvents();
    }

    private void updateCombo(JComboBox combo)
    {
        combo.removeAllItems();

        for(MesaDTO m: VC.getMesasLibres())
        {
            combo.addItem(m.mesaID + " - " + m.descripcion);
        }

        combo.revalidate();
        combo.repaint();
    }

    private void cargarTabla()
    {
        table1.setModel(new MesasTableModel(VC.getMesasOcupadas()));
    }

    private void loadEvents()
    {
        cargarMesaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VC.libre2ocupada((String) comboBox1.getSelectedItem());
                updateCombo(comboBox1);
                cargarTabla();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                FrmCuentaMesa open = new FrmCuentaMesa();
            }
        });
    }
}
