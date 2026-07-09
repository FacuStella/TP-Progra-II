package sherlockhomes;

import java.util.ArrayList;

public class SocioUtils {
    public static Socio buscarSocioPorDni(ArrayList<Socio> socios, int dni) {
        for (Socio s : socios) {
            if (s.getDNI() == dni) {
                return s;
            }
        }
        return null;
    }

    public static void listarSocios(ArrayList<Socio> socios) {
        System.out.println("=== Lista de Socios ===");
        for (Socio s : socios) {
            System.out.println("Nombre: " + s.getNombre() +
                               " | DNI: " + s.getDNI() +
                               " | Teléfono: " + s.getTelefono() +
                               " | Dirección: " + s.getDireccion());
        }
    }
}
