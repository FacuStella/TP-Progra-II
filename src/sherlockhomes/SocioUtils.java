package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class SocioUtils {
    public static Socio buscarSocioPorDni(ArrayList<Socio> socios, int dni) {
        for (Socio s : socios) {
            if (s.getDNI() == dni) {
                return s;
            }
        }
        return null;
    }
    public static void mostrarSocio(Socio socio) {
        System.out.println("Nombre: " + socio.getNombre() +
                       " | DNI: " + socio.getDNI() +
                       " | Teléfono: " + socio.getTelefono() +
                       " | Dirección: " + socio.getDireccion());
    }

    public static void listarSocios(ArrayList<Socio> socios) {
        System.out.println("=== Lista de Socios ===");
        for (Socio s : socios) {
            mostrarSocio(s);
        }
    }

    public static void eliminarSocio(ArrayList<Socio> socios, Socio socio) {
        Iterator<Socio> it = socios.iterator();
        while (it.hasNext()) {
            Socio socioAux = it.next();
            if (socioAux.getDNI() == socio.getDNI()) {
                it.remove(); 
            }
        }
    }
    
    public static void listarSocioVehiculos(Socio socio) {
        System.out.println("=== Lista de Vehiculos del Socio "+socio.getNombre()+" ===");
        VehiculoUtils.listarVehiculos(socio.getVehiculos());
    }
    
    public static void listarSocioGarages(Socio socio) {
        System.out.println("=== Lista de Garages del Socio "+socio.getNombre()+" ===");
        GarageUtils.listarGarages(socio.getGarages());
    }
}
