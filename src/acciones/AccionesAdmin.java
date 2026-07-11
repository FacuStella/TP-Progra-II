package acciones;

import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Empleado;
import sherlockhomes.Garage;
import sherlockhomes.Socio;
import sherlockhomes.Usuario;
import sherlockhomes.Vehiculo;
import sherlockhomes.Zona;

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
                System.out.println("Se gestionan garages.");
            }
            case 4 -> {
                System.out.println("Se gestionan zonas.");
                AccionesAdminSocio accionesAdminSocio = new AccionesAdminSocio();
                accionesAdminSocio.ejecutar(usuarioLogueado, opcAdm, sc);
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
