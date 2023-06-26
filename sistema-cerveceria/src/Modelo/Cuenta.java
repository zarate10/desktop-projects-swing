package Modelo;

import DTO.CuentaDTO;
import DTO.PresentacionDTO;
import DTO.ProductoDTO;
import DTO.VariedadDTO;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    static int cantidadCuentas = 0;

    private int id;
    private int mesaID;
    private List<Producto> productos;
    private float precioTotal;
    private float descuentoTotal;
    private int litrosMesa;

    public Cuenta()
    {
        this.id = cantidadCuentas;
        this.precioTotal = 0;
        this.descuentoTotal = 0;
        this.litrosMesa = 0;
        cantidadCuentas++;
    }

    public int getId() {
        return id;
    }

    public void addCuenta(PresentacionDTO presentacion, VariedadDTO variedad)
    {
        String nombreProducto = presentacion.descripcion + "-" + variedad.descripcion;
        Producto prod = null;

        for(Producto p: productos)
        {
            if(p.getNombreProducto().equals(nombreProducto))
            {
                prod = p;
            }
        }

        if (prod != null)
            prod.incrementCantidad();
        else
            productos.add(new Producto(variedad, presentacion));

        precioTotal += variedad.precioLt * ((float) presentacion.cantidadCC / 100);
        litrosMesa += presentacion.cantidadCC;
    }

    public CuentaDTO toDTO()
    {
        CuentaDTO dto = new CuentaDTO();
        dto.id = id;
        dto.mesaID = mesaID;
        dto.productosDTO = getProductosDTO();
        dto.precioTotal = precioTotal;
        dto.descuentoTotal = descuentoTotal;
        dto.litrosMesa = litrosMesa;
        return dto;
    }

    public List<ProductoDTO> getProductosDTO()
    {
        List<ProductoDTO> listDTO = new ArrayList<>();
        for(Producto p: productos)
        {
            listDTO.add(p.toDTO());
        }
        return listDTO;
    }
    // acá hacer el análisis de cada cuenta para posterior análisis global
}
