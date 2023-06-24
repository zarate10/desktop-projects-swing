package Modelo;

public class Tarjeta {

    // Atributos de la clase
    private String tipoTarjeta;
    private float descuento;


    // Constructor
    public Tarjeta(String tipoTarjeta, float descuento){
        this.tipoTarjeta = tipoTarjeta;
        this.descuento = descuento;
    }

    // Metodos
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }
    public float getDescuento() {
        return descuento;
    }
}
