package Controlador;

public class CerveceriaController {
    // SINGLETON
    private static CerveceriaController instance;

    public static CerveceriaController getInstance() {
        if (instance == null)
        {
            instance = new CerveceriaController();
        }
        return instance;
    }

    public int cervezaMasTomada(){
        return 0;
    }

    public int getTipoMasTomada(){
        return 0;
    }
}
