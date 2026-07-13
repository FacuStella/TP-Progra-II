package sherlockhomes;

import java.util.ArrayList;
import static sherlockhomes.Persistencia.cargarZonas;
import static sherlockhomes.Persistencia.guardarZonas;

public class ZonaRepositoryFile implements ZonaRepository {
    
    ArrayList<Zona> zonas;
    GarageRepositoryFile garageRepository;
    EmpleadoRepositoryFile employeeRepository;
    
    public ZonaRepositoryFile(){
        garageRepository = new GarageRepositoryFile();
    }
    
    @Override
    public boolean crearZona(String letra, int contadorLuz, String ancho, String profundidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Zona buscarZonaPorLetra(String letra) {
        zonas = cargarZonas();
        
        for (Zona z : zonas) {
            if (z.getLetra().equals(letra)) {
                return z;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeZonaPorLetra(String letra) {
        return (buscarZonaPorLetra(letra) != null);
    }
    
    @Override
    public void mostrarZona(Zona zona) {
        System.out.println(
                "Letra: " + zona.getLetra()+
                " | Tipo vehiculos: " + zona.getTipoVehiculos()+
                " | Zona: " + zona.getNumeroVehiculos() +
                " | Dimensiones garage: " + zona.getAnchoGarage() + "x" + zona.getProfundidadGarage()
        );
    }
    
    @Override
    public void listarZonasAll() {
        zonas = cargarZonas();
        System.out.println("=== Lista de todas las zonas ===");
        for (Zona z : zonas) {
            mostrarZona(z);
        }
    }


    @Override
    public void listarZonas(ArrayList<Zona> zonas) {
        System.out.println("=== Lista de zonas ===");
        for (Zona z : zonas) {
            mostrarZona(z);
        }
    }
   
    @Override
    public void listarZonaGarages(Zona zona) {
        System.out.println("=== Lista de Garages de Zona "+zona.getLetra()+" ===");
        for (Garage g : zona.getGarages()) {
            garageRepository.mostrarGarage(g);
        }
    }
    
    @Override
    public void asignarZonaEmpleado(String letra, int codigo) {
        employeeRepository = new EmpleadoRepositoryFile();
        Zona zona = buscarZonaPorLetra(letra);
        
        for (Zona z : zonas) {
            if (z.getLetra().equals(zona.getLetra())) {
                z.asignarEmpleado(employeeRepository.buscarEmpleadoPorCodigo(codigo));
                break; 
            }
        }
        
        guardarZonas(zonas);
    }
    
    @Override
    public void quitarZonaEmpleado(String letra, Empleado empleado) {
        Zona zona = buscarZonaPorLetra(letra);
        
        for (Zona z : zonas) {
            if (z.getLetra().equals(zona.getLetra())) {
                z.quitarEmpleado(empleado);
                break; 
            }
        }
        
        guardarZonas(zonas);
    }


}
