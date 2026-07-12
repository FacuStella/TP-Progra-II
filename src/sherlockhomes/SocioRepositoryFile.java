package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;
import static sherlockhomes.Persistencia.cargarSocios;

public class SocioRepositoryFile implements SocioRepository {
    
    protected ArrayList<Socio> socios;
    protected UsuarioRepositoryFile userRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    protected GarageRepositoryFile garageRepository;
    
    public SocioRepositoryFile(){
        userRepository = new UsuarioRepositoryFile();
    }
    
    @Override
    public boolean crearSocio(String nombre, int DNI, String direccion, String telefono){
        socios = cargarSocios();
        
        Socio socioAux;
        
        socioAux = buscarSocioPorDni(DNI);
        
        if(socioAux != null){
            System.out.println("Ya existe el socio DNI " + DNI + ".");
            return false;
        } else {
                Socio socio = new Socio(nombre, DNI, direccion, telefono);

                userRepository.agregarUsuario(socio);
                
                return true;
        }
    }
    
    @Override
    public Socio buscarSocioPorDni(int dni) {
        socios = cargarSocios();
        
        for (Socio s : socios) {
            if (s.getDNI() == dni) {
                return s;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeSocioPorDni(int DNI) {
        return (buscarSocioPorDni(DNI) != null);
    }
    
    @Override
    public void modificarSocioPorDni(int DNI, String direccion, String telefono) {
        socios = cargarSocios();
        
        Socio socio = buscarSocioPorDni(DNI);
        
        if(!direccion.isBlank()){socio.setDireccion(direccion);}
        if(!direccion.isBlank()){socio.setTelefono(telefono);}

        userRepository.modificarSocio(socio);
    }
    
    public void asignarSocioVehiculo(int DNI, Vehiculo vehiculo){
        socios = cargarSocios();
        
        Socio socio = buscarSocioPorDni(DNI);
        
        socio.agregarVehiculo(vehiculo);
        
        userRepository.modificarSocio(socio);
    }
    
    @Override
    public void quitarVehiculoPorPatente(String patente){
        vehicleRepository = new VehiculoRepositoryFile();
        
        Vehiculo vehiculo = vehicleRepository.buscarVehiculoPorPatente(patente);
        
        Socio socio = vehiculo.getPropietario();
                
        socio.quitarVehiculo(vehiculo);
        
        userRepository.modificarSocio(socio);
    }
    
    @Override
    public void mostrarSocio(Socio socio) {
        System.out.println("Nombre: " + socio.getNombre() +
                       " | DNI: " + socio.getDNI() +
                       " | Teléfono: " + socio.getTelefono() +
                       " | Dirección: " + socio.getDireccion() +
                       " | Fecha ingreso: " + socio.getFechaIngreso());
    }
    
    @Override
    public void mostrarSocioPorDni(int DNI) {
        mostrarSocio(buscarSocioPorDni(DNI));
    }

    @Override
    public void listarSociosAll() {
        socios = cargarSocios();
        System.out.println("=== Lista de Socios ===");
        for (Socio s : socios) {
            mostrarSocio(s);
        }
    }
    
    @Override
    public void listarSocios(ArrayList<Socio> socios) {
        System.out.println("=== Lista de Socios ===");
        for (Socio s : socios) {
            mostrarSocio(s);
        }
    }
    
    @Override
    public void listarSocioVehiculos(Socio socio) {
        vehicleRepository = new VehiculoRepositoryFile();
        vehicleRepository.listarVehiculos(socio.getVehiculos());
    }
    
    @Override
    public void listarSocioGarages(Socio socio) {
        garageRepository = new GarageRepositoryFile();
        garageRepository.listarGarages(socio.getGarages());
    }

    @Override
    public void eliminarSocio(Socio socio) {
        userRepository.eliminarUsuario(socio);
    }
    
    @Override
    public boolean eliminarSocioPorDni(int DNI){
        Socio socioAux;
        
        socioAux = buscarSocioPorDni(DNI);
        
        if(socioAux != null){
            eliminarSocio(socioAux);
            return true;
        } else {
            System.out.println("No se encontró el socio DNI: "+ DNI +":");
            return false;
        }    
    }
}
