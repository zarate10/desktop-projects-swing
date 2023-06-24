package Modelo;

import java.util.Date;

import Modelo.Mesa;
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

    // Metodos

    // preguntar como hacer aca

}
