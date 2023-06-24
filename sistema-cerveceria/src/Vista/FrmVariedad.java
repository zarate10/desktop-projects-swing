package Vista;

import javax.swing.*;

public class FrmVariedad extends JInternalFrame {
    private JPanel panel1;
    private JTable tableCervezas;
    private JComboBox comboBoxTipoCerveza;
    private JButton eliminarButton;
    private JTextField textFieldDeleteID;
    private JTextField textField1;
    private JTextField textField2;
    private JButton guardarButton;

    public FrmVariedad()
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setVisible(true);
        this.setContentPane(panel1);
    }
}
