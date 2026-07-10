package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class ZonaUtils {
    public static Zona buscarZonaPorLetra(ArrayList<Zona> zonas, String letra) {
        for (Zona z : zonas) {
            if (z.getLetra()== letra) {
                return z;
            }
        }
        return null;
    }
    
    public static void mostrarZona(Zona zona) {
        System.out.println(
                "Letra: " + zona.getLetra()+
                " | Tipo vehiculos: " + zona.getTipoVehiculos()+
                " | Zona: " + zona.getNumeroVehiculos() +
                " | Dimensiones garage: " + zona.getAnchoGarage() + "x" + zona.getProfundidadGarage()
        );
    }


    public static void listarZonas(ArrayList<Zona> zonas) {
        System.out.println("=== Lista de Zonas ===");
        for (Zona z : zonas) {
            mostrarZona(z);
        }
    }

    public static void eliminarZona(ArrayList<Zona> zonas, Zona zona) {
        Iterator<Zona> it = zonas.iterator();
        while (it.hasNext()) {
            Zona zonaAux = it.next();
            if (zonaAux.getLetra() == zona.getLetra()) {
                it.remove(); 
            }
        }
    }
    
    public static void listarZonaGarages(Zona zona) {
        System.out.println("=== Lista de Garages de Zona "+zona.getLetra()+" ===");
        for (Garage g : zona.getGarages()) {
            GarageUtils.mostrarGarage(g);
        }
    }
}
