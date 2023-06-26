package Modelo;

import DTO.PresentacionDTO;
import DTO.ProductoDTO;
import DTO.VariedadDTO;

public class Producto {

    private String nombreProducto;
    private int cantidad;

    public Producto(VariedadDTO variedad, PresentacionDTO presentacion)
    {
        this.nombreProducto = presentacion.descripcion + "-" + variedad.descripcion;
        this.cantidad = 1;
    }

    public void incrementCantidad()
    {
        cantidad++;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public ProductoDTO toDTO()
    {
        ProductoDTO dto = new ProductoDTO();
        dto.nombreProducto = nombreProducto;
        dto.cantidad = cantidad;
        return dto;
    }
}
