package view;

import DTO.ReservaDTO;
import controllers.ReservaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VwReserva extends JFrame {

    private JPanel pnlPrincipal;
    private JButton eliminarReservaButton;
    private JLabel fieldDocResp;
    private JLabel fieldTipoHabitacon;
    private JLabel fieldNumHabit;
    private JLabel fieldFLlegada;
    private JLabel fieldFSalida;
    private JLabel fieldDiasTotales;
    private JLabel fieldDescuento;
    private JLabel fieldPrecioTotal;

    public VwReserva(ReservaDTO infoReserva)
    {
        this.setTitle("Información: " + infoReserva.documentoResp);
        this.setBounds(0,0,450,290);
        this.setContentPane(pnlPrincipal);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.fieldDocResp.setText(String.valueOf(infoReserva.documentoResp));
        this.fieldFLlegada.setText(String.valueOf(infoReserva.fechaLlegada));
        this.fieldFSalida.setText(String.valueOf(infoReserva.fechaSalida));
        this.fieldPrecioTotal.setText(String.valueOf(infoReserva.precio));
        this.fieldTipoHabitacon.setText(String.valueOf(infoReserva.tipoHabitacion));
        this.fieldNumHabit.setText(String.valueOf(infoReserva.numHabitacion));


        cargarEventos(infoReserva);
    }

    private void cargarEventos(ReservaDTO infoReserva)
    {
        eliminarReservaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                VwMain vw = VwMain.getInstance();

                ReservaController.getInstance().eliminarReserva(infoReserva.id);

                vw.actualizarTabla();
                dispose();
            }
        });
    }
}
