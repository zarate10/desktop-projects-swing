package Vista;

import javax.swing.*;

public class FrmTarjetas extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField txtNombreTarjeta;
    private JTextField txtDescuentoTarjeta;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JTextField textFieldDeleteID;

    public FrmTarjetas()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
    }
}
