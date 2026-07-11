package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;
import static sherlockhomes.Persistencia.cargarVehiculos;
import static sherlockhomes.Persistencia.guardarVehiculos;

public class VehiculoRepositoryFile implements VehiculoRepository {
    
    ArrayList<Vehiculo> vehiculos;
    GarageRepositoryFile garageRepository;
    
    public VehiculoRepositoryFile(){
    }
    
    @Override
    public boolean crearVehiculo(String patente, String marca, String tipo, String dimensiones, Socio socio){ 
        if(existeVehiculoPorPatente(patente)){
            System.out.println("Ya existe el vehiculo patente " + patente + ".");
            return false;
        } else {
                Vehiculo vehiculo = new Vehiculo(patente, marca, tipo, dimensiones, socio);

                vehiculos.add(vehiculo);
                
                guardarVehiculos(vehiculos);
                
                return true;
        }
    }
               
    @Override
    public Vehiculo buscarVehiculoPorPatente(String patente) {
        vehiculos = cargarVehiculos();
        
        for (Vehiculo v : vehiculos) {
            if (v.getPatente() == patente) {
                return v;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeVehiculoPorPatente(String patente) {
        return (buscarVehiculoPorPatente(patente) != null);
    }
    
    @Override
    public boolean tieneGarageAsignado(String patente){
        return (buscarVehiculoPorPatente(patente).getGarageAsignado() != null);
    }
    
    @Override
    public void asignarVehiculoGarage(String patente, int garage){
        garageRepository = new GarageRepositoryFile();
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        
        for (Vehiculo v : vehiculos) {
            if (v.getPatente() == vehiculo.getPatente()) {
                v.asignarGarage(garageRepository.buscarGaragePorNumero(garage));
                break; 
            }
        }
        
        guardarVehiculos(vehiculos);
    }
    
        @Override
    public void quitarVehiculoGarage(String patente){
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        
        for (Vehiculo v : vehiculos) {
            if (v.getPatente()== vehiculo.getPatente()) {
                v.removerGarage();
                break; 
            }
        }
        
        guardarVehiculos(vehiculos);
    }
    
    @Override
    public void quitarGarageVehiculo(int numero){
        garageRepository = new GarageRepositoryFile();
        Vehiculo vehiculo = buscarVehiculoPorPatente(garageRepository.buscarGaragePorNumero(numero).getVehiculoOcupante().getPatente());
        
        for (Vehiculo v : vehiculos) {
            if (v.getPatente()== vehiculo.getPatente()) {
                v.removerGarage();
                break; 
            }
        }
        
        guardarVehiculos(vehiculos);
    }
    
    @Override
    public void mostrarVehiculo(Vehiculo vehiculo) {
            System.out.println("Patente: " + vehiculo.getPatente() +
                               " | Marca: " + vehiculo.getMarca() +
                               " | Tipo: " + vehiculo.getTipo() +
                               " | Dimensiones: " + vehiculo.getDimensiones() +
                               " | Propietario: " + vehiculo.getPropietario().getNombre() + " DNI: " + vehiculo.getPropietario().getDNI());
    }
    
    @Override
    public void mostrarVehiculoPorPatente(String patente){
        mostrarVehiculo(buscarVehiculoPorPatente(patente));
    }
    
    @Override
    public void mostrarVehiculoGarage(Vehiculo vehiculo) {
        garageRepository = new GarageRepositoryFile();
        System.out.println("=== Garaga del vehiculo ===");
        garageRepository.mostrarGarage(vehiculo.getGarageAsignado());
    }
    
    @Override
    public void listarVehiculosAll() { 
        vehiculos = cargarVehiculos();
        
        System.out.println("=== Lista de todos los vehiculos ===");
        for (Vehiculo v : vehiculos) {
            mostrarVehiculo(v);
        }
    }
    
    @Override
    public void listarVehiculos(ArrayList<Vehiculo> vehiculos) {
        System.out.println("=== Lista de vehiculos ===");
        for (Vehiculo v : vehiculos) {
            mostrarVehiculo(v);
        }
    }
    
    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos = cargarVehiculos();
        
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo vehiculoAux = it.next();
            if (vehiculoAux.getPatente()== vehiculo.getPatente()) {
                it.remove(); 
            }
        }
        
        guardarVehiculos(vehiculos);
    }
    
    @Override
    public boolean eliminarVehiculoPorPatente(String patente) {
        eliminarVehiculo(buscarVehiculoPorPatente(patente));
        return true;
    }
}
