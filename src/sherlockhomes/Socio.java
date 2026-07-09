package sherlockhomes;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static sherlockhomes.TipoUsuario.SOCIO;

public class Socio extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L; 

    protected Date fechaIngreso;
    protected ArrayList<Vehiculo> vehiculos;
    protected ArrayList<Garage> garages;

    public Socio(String nombre, int DNI, String direccion, String telefono, String username, String password) {
        super(nombre, DNI, direccion, telefono, username, password, SOCIO);
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

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
}