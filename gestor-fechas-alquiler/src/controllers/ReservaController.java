package controllers;

import DTO.ReservaDTO;
import models.ReservaModel;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class ReservaController {
    static private ReservaController instance;
    private List<ReservaModel> reservas;

    private ReservaController()
    {
        reservas = new ArrayList<ReservaModel>();
    }

    static public ReservaController getInstance()
    {
        if (instance == null)
        {
            instance = new ReservaController();
        }
        return instance;
    }

    public boolean crearReserva(String fLlegada, String fSalida, int docResp, String tipoHabitacion, String numHabitacion, String descuento) throws ParseException
    {
        ReservaModel nuevaRes = new ReservaModel(fLlegada, fSalida, docResp, tipoHabitacion, Integer.parseInt(numHabitacion), descuento);

        /* verificamos fechas si la fecha de llegada es menor a la fecha de salida */
        if (!nuevaRes.fechaSmenorFechaL())
        {
            for (ReservaModel r: reservas)
            {
                /* se verifica que las fechas, tipo de habitación y num de habitación no estén ocupadas,
                   además de que una persona reserve varias veces */
                if (nuevaRes.getFechaLlegada().equals(r.getFechaLlegada()) && nuevaRes.getFechaSalida().equals(r.getFechaSalida())
                        && nuevaRes.getNumHabitacion() == r.getNumHabitacion() && nuevaRes.getTipoHabitacion().equals(r.getTipoHabitacion())
                        && nuevaRes.getDocumentoResp() == r.getDocumentoResp())
                {
                    return false;
                }

            }

            /* se agrega a la tabla de reservas */
            reservas.add(nuevaRes);
            return true;
        }

        return false;
    }

    public ReservaDTO getInfoReserva(int documento)
    {
        ReservaDTO infoReserva = null;

        for (ReservaModel r: reservas) {
            if (r.getDocumentoResp() == documento)
            {
                infoReserva = r.toDTO();
            }
        }

        return infoReserva;
    }

    public void eliminarReserva(int id)
    {
        reservas.remove(id);
    }

    public List<ReservaDTO> getReservasDTO()
    {
        List<ReservaDTO> listaReservasDTO = new ArrayList<>();

        for (ReservaModel r: reservas)
        {
            listaReservasDTO.add(r.toDTO());
        }

        return listaReservasDTO;
    }
}
