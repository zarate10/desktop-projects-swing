package Vista;

import javax.swing.*;

public class FrmPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JDesktopPane desktopPane;

    public FrmPrincipal(){
        desktopPane.add(new FrmFormPrincipal(desktopPane));
        this.setContentPane(pnlPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CERVECERÍA");
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
    }
}
