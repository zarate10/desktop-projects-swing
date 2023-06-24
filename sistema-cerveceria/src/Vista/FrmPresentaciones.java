package Vista;

import javax.swing.*;

public class FrmPresentaciones extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton guardarButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton eliminarButton;
    private JTextField textField5;
    private JComboBox comboBox1;

    public FrmPresentaciones()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
    }
}
