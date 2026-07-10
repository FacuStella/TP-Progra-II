package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class VehiculoUtils {
    public static Vehiculo buscarVehiculoPorPatente(ArrayList<Vehiculo> vehiculos, String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula() == patente) {
                return v;
            }
        }
        return null;
    }
    
    public static void mostrarVehiculo(Vehiculo vehiculo) {
            System.out.println("Patente: " + vehiculo.getMatricula() +
                               " | Marca: " + vehiculo.getMarca() +
                               " | Tipo: " + vehiculo.getTipo() +
                               " | Dimensiones: " + vehiculo.getDimensiones() +
                               " | Propietario: " + vehiculo.getPropietario().getNombre() + " DNI: " + vehiculo.getPropietario().getDNI());
    }

    public static void listarVehiculos(ArrayList<Vehiculo> vehiculos) {
        System.out.println("=== Lista de Vehiculos ===");
        for (Vehiculo v : vehiculos) {
            mostrarVehiculo(v);
        }
    }

    public static void eliminarVehiculo(ArrayList<Vehiculo> vehiculos, Vehiculo vehiculo) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo vehiculoAux = it.next();
            if (vehiculoAux.getMatricula()== vehiculo.getMatricula()) {
                it.remove(); 
            }
        }
    }
}
