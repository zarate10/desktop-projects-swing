package Vista;

import javax.swing.*;

public class FrmMesas extends JInternalFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JButton eliminarButton;
    private JButton guardarButton;
    private JTextField textField2;

    public FrmMesas()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
    }
}
