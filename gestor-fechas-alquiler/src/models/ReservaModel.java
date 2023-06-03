package models;

import DTO.ReservaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaModel {

    public enum TipoHabitacion { Chica, Mediana, Grande }
    static int cantidadReserva = 0;
    private double precioPorNoche;

    private int id;
    private int documentoResp;
    private double precio;
    private int numHabitacion;
    private int descuento;
    private Date fechaLlegada;
    private Date fechaSalida;
    private TipoHabitacion tipoHabitacion;

    public ReservaModel(String fechaLlegada, String fechaSalida, int documentoResp, String tipoHabitacion, int numHabitacion, String descuento) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.id = cantidadReserva;
        this.fechaLlegada = formato.parse(fechaLlegada);
        this.fechaSalida = formato.parse(fechaSalida);
        this.documentoResp = documentoResp;
        this.numHabitacion = numHabitacion;
        this.descuento = switch (descuento)
        {
            case "Descuento 10%" -> 10;
            case "Descuento 20%" -> 20;
            default -> 0;
        };
        this.tipoHabitacion = switch (tipoHabitacion)
        {
            case "Habitación mediana" -> TipoHabitacion.Mediana;
            case "Habitación grande" -> TipoHabitacion.Grande;
            default -> TipoHabitacion.Chica;
        };
        this.precio = calcularPrecio();

        cantidadReserva++;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public static int getCantidadReserva() {
        return cantidadReserva;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public int getDocumentoResp() {
        return documentoResp;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    private double calcularPrecio()
    {
        precioPorNoche = switch (tipoHabitacion)
        {
            case Mediana -> 12000;
            case Grande -> 14000;
            default -> 10000;
        };

        // Calcular la diferencia en milisegundos
        long diferenciaMilisegundos = this.getFechaSalida().getTime() - this.getFechaLlegada().getTime();

        // Convertir la diferencia a días
        long dias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);

        double descontar = (dias * this.precioPorNoche) * this.descuento / 100;
        return (dias * this.precioPorNoche) - descontar ;
    }

    public ReservaDTO toDTO()
    {
        ReservaDTO dto = new ReservaDTO();
        dto.tipoHabitacion = this.tipoHabitacion;
        dto.documentoResp = this.documentoResp;
        dto.numHabitacion = this.numHabitacion;
        dto.fechaLlegada = this.fechaLlegada;
        dto.fechaSalida = this.fechaSalida;
        dto.precio = this.precio;
        dto.id = this.id;

        return dto;
    }

    public boolean fechaSmenorFechaL ()
    {
        return fechaSalida.before(fechaLlegada);
    }
}
