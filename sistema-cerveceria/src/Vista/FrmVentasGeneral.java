package Vista;

import Controlador.VentasController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVentasGeneral extends JInternalFrame {
    private JPanel panel1;
    private JPanel menuCliente;
    private JButton mesasOcupadasButton;
    private JButton historialVentasButton;
    private JButton volverButton;
    private JDesktopPane desktopPaneEmb;
    private JDesktopPane desktopPaneHome;

    public FrmVentasGeneral(JDesktopPane desktopPaneHome)
    {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        this.setVisible(true);
        this.setContentPane(panel1);
        this.desktopPaneHome = desktopPaneHome;
        this.desktopPaneEmb.add(new FrmMesasOcupadas());

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
        mesasOcupadasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneEmb, new FrmMesasOcupadas());
            }
        });
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeDesktopPane(desktopPaneHome, new FrmFormPrincipal(desktopPaneHome));
            }
        });
    }
}
