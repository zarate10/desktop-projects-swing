package Modelo;

import java.util.Date;

public class Venta {
    // ID
    static int cantidadVentas = 0;

    // Atributos
    private int ventaID;
    private Date fchVenta;

    // Constructor
    public Venta(int ventaID, Date fchVenta){
        this.ventaID = cantidadVentas;
        this.fchVenta = fchVenta;
        cantidadVentas++;
    }
}
