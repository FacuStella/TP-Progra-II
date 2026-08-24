package acciones;

import java.util.Scanner;
import sherlockhomes.Usuario;

public class AccionesAdmin {

    public void ejecutar(Usuario usuarioLogueado, int opc, int opcAdm, Scanner sc) {
       
        switch (opc) {
            case 1 -> {
                AccionesAdminSocio accionesAdmin = new AccionesAdminSocio();
                accionesAdmin.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 2 -> {
                AccionesAdminVehiculo accionesAdmin = new AccionesAdminVehiculo();
                accionesAdmin.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 3 -> {
                AccionesAdminGarage accionesAdmin = new AccionesAdminGarage();
                accionesAdmin.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 4 -> {
                AccionesAdminZona accionesAdmin = new AccionesAdminZona();
                accionesAdmin.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 5 -> {
                AccionesAdminEmpleado accionesAdmin = new AccionesAdminEmpleado();  
                accionesAdmin.ejecutar(usuarioLogueado, opcAdm, sc);
            }
            case 0 -> {}
            default -> {}
        }
    }
}
