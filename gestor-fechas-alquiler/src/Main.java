
import DTO.ReservaDTO;
import controllers.ReservaController;
import view.VwMain;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        ReservaController rc = ReservaController.getInstance();
        rc.crearReserva("20/09/2003", "19/09/2004", 291241, "Habitación chica", "101", "Sin descuento");
        rc.crearReserva("1/2/2023", "19/09/2023", 63434, "Habitación grande", "101", "Descuento 20%");
        rc.crearReserva("1/2/2023", "19/09/2023", 29141, "Habitación mediana", "101", "Descuento 10%");
        rc.crearReserva("9/3/2023", "31/12/2025", 294141, "Habitación chica", "101", "Sin descuento");
        for (ReservaDTO r:
             ReservaController.getInstance().getReservasDTO()) {
            System.out.println(r.fechaSalida.before(r.fechaLlegada));
        }
        VwMain vw = VwMain.getInstance();
    }
}