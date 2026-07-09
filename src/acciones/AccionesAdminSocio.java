package acciones;

import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Usuario;

public class AccionesAdminSocio {

    public void ejecutar(ArrayList<Usuario> usuariosAux, Usuario usuarioAux, int opc, Scanner sc) {

        switch (opc) {
            case 1 -> {
                System.out.println("Se agrega socio.");
            }
            case 2 -> {
                System.out.println("Se modifica socio.");
            }
            case 3 -> {
                System.out.println("Se elimina socio.");
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
