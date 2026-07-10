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

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, ArrayList<Empleado> empleados, ArrayList<Vehiculo> vehiculos, ArrayList<Garage> garages, ArrayList<Zona> zonas, Usuario usuarioLogueado, int opc, int opcAdm, Scanner sc) {
       
        switch (opc) {
            case 1 -> {
                AccionesAdminSocio accionesAdminSocio = new AccionesAdminSocio();
                accionesAdminSocio.ejecutar(usuarios, socios, usuarioLogueado, opcAdm, sc);
            }
            case 2 -> {
                AccionesAdminVehiculo accionesAdminVehiculo = new AccionesAdminVehiculo();
                accionesAdminVehiculo.ejecutar(usuarios, socios, vehiculos, usuarioLogueado, opcAdm, sc);
            }
            case 3 -> {
                System.out.println("Se gestionan garages.");
            }
            case 4 -> {
                System.out.println("Se gestionan zonas.");
            }
            case 5 -> {
                System.out.println("Se gestionan empleados.");
            }
            case 0 -> {
                return;
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
