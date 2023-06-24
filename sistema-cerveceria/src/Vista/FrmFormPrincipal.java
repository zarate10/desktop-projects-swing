package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmFormPrincipal extends JInternalFrame {
    private JButton gestionarSistemaButton;
    private JButton ventasButton;
    private JButton análisisButton;
    private JPanel pnlPrincipal;
    private JDesktopPane desktopPane;

    public FrmFormPrincipal(JDesktopPane desktopPane)
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setContentPane(pnlPrincipal);
        this.setVisible(true);

        this.desktopPane = desktopPane;
        loadEvents();
    }

    private void loadEvents()
    {
        gestionarSistemaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                desktopPane.remove(0);
                desktopPane.add(new FrmGestionarSistema(desktopPane));
                desktopPane.revalidate();
                desktopPane.repaint();
            }
        });
    }
}
