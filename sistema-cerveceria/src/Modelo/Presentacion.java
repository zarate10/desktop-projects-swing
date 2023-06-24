package Modelo;

public class Presentacion {
    // ID
    static int cantidadPresentaciones = 0;

    // Atributos
    private int presentacionID;
    private String descripcion;
    private int cantidadCC;
    private float descuentoHH;
    private float descuentoGeneral;

    // Constructo
    public Presentacion(String descripcion, int cantidadCC, float descuentoHH, float descuentoGeneral){
        this.presentacionID = cantidadPresentaciones;
        this.descripcion = descripcion;
        this.cantidadCC = cantidadCC;
        this.descuentoHH = descuentoHH;
        this.descuentoGeneral = descuentoGeneral;
        cantidadPresentaciones++;
    }

    public int getPresentacionID() {
        return presentacionID;
    }

    // preguntar si va getDescuentoHH o getDescuento (consultar en el starUml)
    public float getDescuento(boolean esHH) {
        return descuentoHH; // y ver que retorna
    }

    public int getCantidadCC() {
        return cantidadCC;
    }
}
