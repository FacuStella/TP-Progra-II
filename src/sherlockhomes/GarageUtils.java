package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class GarageUtils {
    public static Garage buscarGaragePorNumero(ArrayList<Garage> garages, int numero) {
        for (Garage g : garages) {
            if (g.getNumeroGarage()== numero) {
                return g;
            }
        }
        return null;
    }
    
    public static void mostrarGarage(Garage garage) {
        System.out.println(
                "Numero: " + garage.getNumeroGarage() +
                " | Contador de luz: " + garage.getLecturaContadorLuz()+
                " | Mantenimiento: " + (garage.isMantenimientoContratado() ? "Si" : "No") +
                " | Zona: " + garage.getZona().getLetra() +
                (
                    (garage.getVehiculoOcupante() != null) ? 
                    " | Vehiculo: " + garage.getVehiculoOcupante().getMarca() + " Patente: " + garage.getVehiculoOcupante().getMatricula() +
                    " | Propietario: " + garage.getPropietario().getNombre() + " DNI: " + garage.getPropietario().getDNI() 
                     : "")
                );
    }


    public static void listarGarages(ArrayList<Garage> garages) {
        System.out.println("=== Lista de Garages ===");
        for (Garage g : garages) {
            mostrarGarage(g);
        }
    }

    public static void eliminarGarage(ArrayList<Garage> garages, Garage garage) {
        Iterator<Garage> it = garages.iterator();
        while (it.hasNext()) {
            Garage garageAux = it.next();
            if (garageAux.getNumeroGarage() == garage.getNumeroGarage()) {
                it.remove(); 
            }
        }
    }
}
