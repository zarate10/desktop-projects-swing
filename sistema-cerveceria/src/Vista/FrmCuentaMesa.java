package Vista;

import Controlador.ParametrosController;
import Controlador.VentasController;
import DTO.PresentacionDTO;
import DTO.VariedadDTO;
import Vista.tables.ProductoTableModel;

import javax.swing.*;

public class FrmCuentaMesa extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton cerrarMesaButton;
    private JComboBox comboPresentacion;
    private JComboBox comboVariedad;
    private JButton agregarButton;
    private JPanel total;
    private ParametrosController PC;

    public FrmCuentaMesa()
    {
        this.setVisible(true);
        this.setContentPane(panel1);
        this.setSize(600, 350);
        this.setLocationRelativeTo(this.getParent());

        PC = ParametrosController.getInstance();
        cargarCombos();
    }

    // usando genéricos se puede hacer una solución más sencilla y escalable, no más eficiente.
    // pero tendría que reestructurar todo el código y no tengo ganas. Práctica de parcial.
    private void cargarCombos()
    {
        comboPresentacion.removeAllItems();
        for(PresentacionDTO p: PC.getPresentacionesDTO())
        {
            comboPresentacion.addItem(p.presentacionID+" - "+ p.descripcion + " - " + p.cantidadCC + " CC");
        }
        comboPresentacion.revalidate();
        comboPresentacion.repaint();

        comboVariedad.removeAllItems();
        for(VariedadDTO v: PC.getVariedadesDTO())
        {
            comboVariedad.addItem(v.ID + " - "+ v.descripcion + " - " + v.tipo);
        }
        comboVariedad.revalidate();
        comboVariedad.repaint();
    }
}
