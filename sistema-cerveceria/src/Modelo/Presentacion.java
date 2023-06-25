package Modelo;

import DTO.PresentacionDTO;

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

    public float getDescuento(boolean esHH) {
        return descuentoHH; // y ver que retorna
    }

    public int getCantidadCC() {
        return cantidadCC;
    }

    public PresentacionDTO toDTO()
    {
        PresentacionDTO dto = new PresentacionDTO();
        dto.presentacionID = presentacionID;
        dto.descripcion = descripcion;
        dto.cantidadCC = cantidadCC;
        dto.descuentoHH = descuentoHH;
        dto.descuentoGeneral = descuentoGeneral;
        return dto;
    }
}
