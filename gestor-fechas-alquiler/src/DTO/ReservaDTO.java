package DTO;

import models.ReservaModel;

import java.util.Date;

public class ReservaDTO {
    public int id;
    public int documentoResp;
    public double precio;
    public Date fechaLlegada;
    public Date fechaSalida;
    public int numHabitacion;
    public ReservaModel.TipoHabitacion tipoHabitacion;
}
