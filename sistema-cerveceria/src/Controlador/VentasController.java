package Controlador;

import DTO.CuentaDTO;
import DTO.MesaDTO;
import DTO.ProductoDTO;
import Modelo.Cuenta;
import Modelo.Variedad;

import java.util.ArrayList;
import java.util.List;

public class VentasController {
    static public VentasController instance;

    List<MesaDTO> mesasLibres;
    List<MesaDTO> mesasOcupadas;
    List<Cuenta> cuentasActuales;

    private VentasController()
    {
        cuentasActuales = new ArrayList<>();
        mesasLibres = new ArrayList<>();
        mesasOcupadas = new ArrayList<>();
    }

    public static VentasController getInstance() {
        if (instance == null)
            instance = new VentasController();

        return instance;
    }

    public List<MesaDTO> getMesasLibres() {
        return mesasLibres;
    }

    public List<MesaDTO> getMesasOcupadas() {
        return mesasOcupadas;
    }

    public void setMesas(MesaDTO ultimaMesa)
    {
        mesasLibres.add(ultimaMesa);
    }

    private int indiceMesa(int mesaID)
    {
        for(MesaDTO m: mesasLibres)
        {
            if (m.mesaID == mesaID)
                return mesasLibres.indexOf(m);
        }
        return -1;
    }

    public void libre2ocupada(String mesa)
    {
        int mesaID = Integer.parseInt((mesa.split("-")[0]).trim());

        mesasOcupadas.add(mesasLibres.get(indiceMesa(mesaID)));
        mesasLibres.remove(indiceMesa(mesaID));
    }
}
