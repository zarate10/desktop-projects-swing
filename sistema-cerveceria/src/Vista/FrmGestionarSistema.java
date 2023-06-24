package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestionarSistema extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton tarjetasButton;
    private JButton variedadesButton;
    private JButton presentacionesButton;
    private JButton mesasButton;
    private JButton volverButton;
    private JPanel pnlAgregar;
    private JPanel pnlVolver;
    private JDesktopPane desktopPaneCliente;
    private JDesktopPane desktopPaneHome;

    public FrmGestionarSistema(JDesktopPane desktopPaneHome)
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        desktopPaneCliente.add(new FrmTarjetas());
        this.setContentPane(pnlPrincipal);
        this.setVisible(true);

        this.desktopPaneHome = desktopPaneHome;
        loadEvents();
    }

    private void changeDesktopPane(JDesktopPane desktopPane, JInternalFrame frame)
    {
        desktopPane.remove(0);
        desktopPane.add(frame);
        desktopPane.revalidate();
        desktopPane.repaint();
    }

    private void loadEvents()
    {
        /* volver al inicio */
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneHome, new FrmFormPrincipal(desktopPaneHome));
            }
        });
        /* menú */
        tarjetasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneCliente, new FrmTarjetas());
            }
        });
        variedadesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneCliente, new FrmVariedad());
            }
        });

        presentacionesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneCliente, new FrmPresentaciones());
            }
        });
    }
}
