package Modelo;

public class Mesa {

    // ID
    static int cantidadMesas = 0;

    // Atributos
    private int mesaID;
    private String descripcion;


    public Mesa(String descripcion){
        this.mesaID = cantidadMesas;
        this.descripcion = descripcion;
        cantidadMesas++;
    }

    public int getMesaID() {
        return mesaID;
    }
}
