package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;
import static sherlockhomes.Persistencia.cargarGarages;
import static sherlockhomes.Persistencia.guardarGarages;

public class GarageRepositoryFile implements GarageRepository {
    
    protected ArrayList<Garage> garages;
    protected VehiculoRepositoryFile vehicleRepository;
    
    public GarageRepositoryFile(){
    }
    
    @Override
    public boolean crearGarage(Zona zona) {
        garages = cargarGarages();
        
        garages.add(new Garage(zona));
        
        guardarGarages(garages);
        
        return true;
    }
    
    @Override
    public Garage buscarGaragePorNumero(int numero) {
        garages = cargarGarages();
        
        for (Garage g : garages) {
            if (g.getNumeroGarage()== numero) {
                return g;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Garage> buscarGaragePorSocio(Socio socio) {
        garages = cargarGarages();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean existeGaragePorNumero(int numero) {
        return (buscarGaragePorNumero(numero) != null);
    }
    
    public boolean tieneVehiculoAsignado(int numero){
        return (buscarGaragePorNumero(numero).getVehiculoOcupante() != null);    
    }
    
    @Override
    public void asignarGarageVehiculo(int numero, String patente){
        vehicleRepository = new VehiculoRepositoryFile();
        Garage garage = buscarGaragePorNumero(numero);
        
        for (Garage g : garages) {
            if (g.getNumeroGarage()== garage.getNumeroGarage()) {
                g.asignarVehiculo(vehicleRepository.buscarVehiculoPorPatente(patente));
                break; 
            }
        }
        
        guardarGarages(garages);
    }
    
    @Override
    public void quitarGarageVehiculo(int numero){
        Garage garage = buscarGaragePorNumero(numero);
        
        for (Garage g : garages) {
            if (g.getNumeroGarage()== garage.getNumeroGarage()) {
                g.removerVehiculo();
                break; 
            }
        }
        
        guardarGarages(garages);
    }
    
    @Override
    public void quitarVehiculoGarage(String patente){
        vehicleRepository = new VehiculoRepositoryFile();
        Garage garage = buscarGaragePorNumero(vehicleRepository.buscarVehiculoPorPatente(patente).getGarageAsignado().getNumeroGarage());
        
        for (Garage g : garages) {
            if (g.getNumeroGarage()== garage.getNumeroGarage()) {
                g.removerVehiculo();
                break; 
            }
        }
        
        guardarGarages(garages);
    }
    
    @Override
    public void mostrarGarage(Garage garage) {
        System.out.println(
                "Numero: " + garage.getNumeroGarage() +
                " | Contador de luz: " + garage.getLecturaContadorLuz()+
                " | Mantenimiento: " + (garage.isMantenimientoContratado() ? "Si" : "No") +
                " | Zona: " + garage.getZona().getLetra() +
                (
                    (garage.getVehiculoOcupante() != null) ? 
                    " | Vehiculo: " + garage.getVehiculoOcupante().getMarca() + " Patente: " + garage.getVehiculoOcupante().getPatente() +
                    " | Propietario: " + garage.getPropietario().getNombre() + " DNI: " + garage.getPropietario().getDNI() 
                     : "")
                );
    }
    
    @Override
    public void listarGaragesAll() {
        garages = cargarGarages();
        System.out.println("=== Lista de Garages ===");
        for (Garage g : garages) {
            mostrarGarage(g);
        }
    }


    @Override
    public void listarGarages(ArrayList<Garage> garages) {
        System.out.println("=== Lista de Garages ===");
        for (Garage g : garages) {
            mostrarGarage(g);
        }
    }
}
