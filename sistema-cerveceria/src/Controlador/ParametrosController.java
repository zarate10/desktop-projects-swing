package Controlador;

import DTO.MesaDTO;
import DTO.PresentacionDTO;
import DTO.TarjetaDTO;
import DTO.VariedadDTO;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class ParametrosController {
    /* ----------------------------------- */
    /* ------------ atributos ------------ */
    /* ----------------------------------- */

    // Singletton Pattern
    private static ParametrosController instance;

    // atributos generales
    private VentasController VC;
    private List<Tarjeta> tarjetas;
    private List<Variedad> variedades;
    private List<Presentacion> presentaciones;
    private List<Mesa> mesas;

    /* ----------------------------------- */
    /* ------------ métodos ------------ */
    /* ----------------------------------- */

    // método constructor en singleton
    private ParametrosController(){
        // mantiene el estado general
        tarjetas = new ArrayList<Tarjeta>();
        variedades = new ArrayList<Variedad>();
        presentaciones = new ArrayList<Presentacion>();
        mesas = new ArrayList<Mesa>();
        VC = VentasController.getInstance();

        crearTarjetas("Gold", 25);
        crearTarjetas("Silver", 15);
        crearTarjetas("Bronze", 5);

        crearVariedades("Suave", 380, "Roja");
        crearVariedades("Fuerte", 380, "Rubia");
        crearVariedades("Normal", 380, "Negra");


        crearPresentaciones("Grande", 3000, 10, 0);
        crearPresentaciones("Pequeña", 750, 25, 0);
        crearPresentaciones("Mediana", 1000, 10, 0);

        crearMesas("Prueba mesa0");
        crearMesas("Prueba mesa1");
        crearMesas("Prueba mesa2");
        System.out.println("cargando parametros contorller");
    }

    // métodos generales
    public static ParametrosController getInstance() {
        if (instance == null)
        {
            instance = new ParametrosController();
        }
        return instance;
    }

    public void crearTarjetas(String tt, float descuento){
        tarjetas.add(new Tarjeta(tt, descuento));
    }

    public void crearVariedades(String descripcion, float precioPorLitro, String tc)
    {
        variedades.add(new Variedad(descripcion,precioPorLitro,tc));
    }

    public void crearPresentaciones(String descripcion, int cantidadCC, float descuentoHH, float descuentoGeneral)
    {
        presentaciones.add(new Presentacion(descripcion, cantidadCC, descuentoHH, descuentoGeneral));
    }

    public void crearMesas(String descripcion){
        mesas.add(new Mesa(descripcion));
        VC.setMesas(mesas.get(mesas.size() - 1).toDTO());
    }

    public Tarjeta getTarjetaByID(String tarjeta)
    {
        for (Tarjeta t: tarjetas)
        {
            if (t.getTipoTarjeta().equals(tarjeta))
            {
                return t;
            }
        }
        return null;
    }

    public Variedad getVariedadByID(int id)
    {
        for (Variedad v: variedades)
        {
            if (v.getVariedadID() == id)
            {
                return v;
            }
        }
        return null;
    }

    public Presentacion getPresentacionByID(int id)
    {
        for (Presentacion p: presentaciones)
        {
            if (p.getPresentacionID() == id)
            {
                return p;
            }
        }
        return null;
    }

    public List<VariedadDTO> getVariedadesDTO()
    {
        List<VariedadDTO> arr = new ArrayList<>();
        for(Variedad obj: variedades)
        {
            arr.add(obj.toDTO());
        }
        return arr;
    }

    public List<TarjetaDTO> getTarjetasDTO()
    {
        List<TarjetaDTO> arr = new ArrayList<>();
        for(Tarjeta obj: tarjetas)
        {
            arr.add(obj.toDTO());
        }
        return arr;
    }

    public List<PresentacionDTO> getPresentacionesDTO()
    {
        List<PresentacionDTO> arr = new ArrayList<>();
        for(Presentacion obj: presentaciones)
        {
            arr.add(obj.toDTO());
        }
        return arr;
    }

    public List<MesaDTO> getMesasDTO()
    {
        List<MesaDTO> arr = new ArrayList<>();
        for(Mesa obj: mesas)
        {
            arr.add(obj.toDTO());
        }
        return arr;
    }
}
