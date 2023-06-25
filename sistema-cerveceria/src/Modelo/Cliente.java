package Modelo;

public class Cliente {

    // ID
    static int cantidadClientes = 0;

    // Atributos
    private int clienteID;
    private String denominacion;
    private Tarjeta tarjeta;

    // Constructor
    public Cliente(int clienteID, String denominacion, Tarjeta tarjeta){
        this.clienteID = cantidadClientes;
        this.denominacion = denominacion;
        this.tarjeta = tarjeta;
        cantidadClientes++;
    }

    // Metodos

    public int getClienteID() {
        return clienteID;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

}
