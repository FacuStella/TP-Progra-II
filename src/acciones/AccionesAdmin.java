package acciones;

import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Usuario;

public class AccionesAdmin {

    public void ejecutar(Usuario usuarioLogueado, int opc, int opcAdm, Scanner sc) {
       
        switch (opc) {
            case 1 -> {
                AccionesAdminSocio accionesAdminSocio = new AccionesAdminSocio();
                accionesAdminSocio.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 2 -> {
                AccionesAdminVehiculo accionesAdminVehiculo = new AccionesAdminVehiculo();
                accionesAdminVehiculo.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 3 -> {
                AccionesAdminGarage accionesAdminGarage = new AccionesAdminGarage();
                accionesAdminGarage.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 4 -> {
                AccionesAdminZona accionesAdminZona = new AccionesAdminZona();
                accionesAdminZona.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 5 -> {
                AccionesAdminEmpleado accionesAdminEmpleado = new AccionesAdminEmpleado();
                accionesAdminEmpleado.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 0 -> {
                return;
            }
            default -> {
                return;
            }
        }
    }
}
