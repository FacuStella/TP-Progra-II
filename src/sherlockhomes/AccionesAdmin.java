package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;

public class AccionesAdmin {

    void ejecutar(ArrayList<Usuario> usuariosAux, Usuario usuarioAux, int opc, Scanner sc) {
        int aux = 0;
        
        switch (opc) {
            case 1 -> {
                Menu vistaGestionSocio = new VistaGestionSocios();
                aux = vistaGestionSocio.a(sc);
                AccionesAdminSocio accionesAdminSocio = new AccionesAdminSocio();
                accionesAdminSocio.ejecutar(usuariosAux, usuarioAux, aux, sc);
                System.out.println("Se gestionan socios.");
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
