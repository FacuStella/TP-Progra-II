package acciones;

import vistas.Vista;
import vistas.admin.VistaGestionSocios;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Empleado;
import sherlockhomes.Socio;
import sherlockhomes.Usuario;

public class AccionesAdmin {

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, ArrayList<Empleado> empleados, Usuario usuarioLogueado, int opc, Scanner sc) {
        int aux = 0;
        
        switch (opc) {
            case 1 -> {
                AccionesAdminSocio accionesAdminSocio = new AccionesAdminSocio();
                accionesAdminSocio.ejecutar(usuarios, usuarioLogueado, aux, sc);
            }
            case 2 -> {
                System.out.println("Se gestionan vehiculos.");
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
                System.out.println("Gracias vuelva prontos.");
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
