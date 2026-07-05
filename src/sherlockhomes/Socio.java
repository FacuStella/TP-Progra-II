package sherlockhomes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends Persona {

    protected Date fechaIngreso;
    protected ArrayList<Vehiculo> vehiculos;
    protected ArrayList<Garage> garages;

    public Socio(String nombre, int DNI, String direccion, String telefono) {
        super(nombre, DNI, direccion, telefono);
        this.fechaIngreso = Date.from(Instant.now());
        this.vehiculos = new ArrayList();
        this.garages = new ArrayList();
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void removerVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void comprarGarage(Garage garage) {
        garages.add(garage);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Garage> getGarages() {
        return garages;
    }   
    
    
}