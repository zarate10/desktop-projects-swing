package view;

import controllers.ReservaController;
import models.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class VwMain extends JFrame {

    static VwMain instance = null;

    private JPanel panelMain;
    private JComboBox comboTipoH;
    private JTextField fieldDocRes;
    private JTextField fieldFechaLlegada;
    private JTextField fieldFechaSalida;
    private JButton guardarButton;
    private JTable table1;
    private JComboBox comboNumHabitacion;
    private JComboBox comboDescuento;

    private ReservaController rc = ReservaController.getInstance();

    private VwMain()
    {
        this.setVisible(true);
        this.setTitle("Gestor de reservas");
        this.setBounds(0, 0, 600, 600);
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        actualizarTabla();
        cargarEventos();
    }

    static public VwMain getInstance() {

        if (instance == null)
        {
            instance = new VwMain();
        }
        return instance;
    }

    private void cargarEventos()
    {
        table1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                VwReserva VwReserva = new VwReserva(ReservaController.getInstance().getInfoReserva(Integer.parseInt(table1.getValueAt(table1.getSelectedRow(), 0).toString())));
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    rc.crearReserva(
                           fieldFechaLlegada.getText(),
                           fieldFechaSalida.getText(),
                           Integer.parseInt(fieldDocRes.getText()),
                           comboTipoH.getSelectedItem().toString(),
                           comboNumHabitacion.getSelectedItem().toString(),
                           comboDescuento.getSelectedItem().toString()
                    );
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                actualizarTabla();
            }
        });
    }

    void actualizarTabla()
    {
        table1.setModel(new TableModel(ReservaController.getInstance().getReservasDTO()));
    }
}
