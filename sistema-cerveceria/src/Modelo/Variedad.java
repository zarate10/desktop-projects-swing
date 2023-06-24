package Modelo;

public class Variedad {
    // ID
    static int cantidadVariedades = 0;

    // Atributos
    private int variedadID;
    private String descripcion;
    private float precioPorLitro;
    private String tipoCerveza;

    // Constructor
    public Variedad(String descripcion, float precioPorLitro, String tipoCerveza){
        this.variedadID = cantidadVariedades;
        this.descripcion = descripcion;
        this.precioPorLitro = precioPorLitro;
        this.tipoCerveza = tipoCerveza;

        cantidadVariedades++;
    }

    // Metodos

    public int getVariedadID() {
        return variedadID;
    }

    public String getTipoCerveza() {
        return tipoCerveza;
    }

    public float getPrecioPorLitro() {
        return precioPorLitro;
    }
}
