package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import sherlockhomes.EmpleadoRepositoryFile;
import sherlockhomes.EntradaCons;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminZona extends AccionesAdmin{
    
    ZonaRepositoryFile zoneRepository;
    VehiculoRepositoryFile vehicleRepository;
    EmpleadoRepositoryFile employeeRepository;
    
    public AccionesAdminZona() {
        zoneRepository = new ZonaRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
        employeeRepository = new EmpleadoRepositoryFile();
    }

    @Override
    public void ejecutar(Usuario usuario, int opc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarZona(); 
            case 2 -> asignarEmpleado();
            case 3 -> quitarEmpleado();
            case 4 -> zoneRepository.listarAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }

    private void registrarZona() {
        System.out.println("=== Registro de Zona ===");
        
        System.out.print("Ingrese zona: ");
        String letra = EntradaCons.ingresaString();

        if(zoneRepository.existePorValorS(letra,0)){
            System.out.println("La zona ya existe.");
            return;
        }
    }


    private void asignarEmpleado() {
        System.out.println("=== Asignar zona a empleado ===");
                
        System.out.print("Ingrese letra de la zona que quiere asignar: ");
        String letra = EntradaCons.ingresaString();

        if(!zoneRepository.existePorValorS(letra,0)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        System.out.println("Ingrese codigo de empleado a asignar: ");
        int codigo = EntradaCons.ingresaInt();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.asignarEmpleadoZona(codigo, zoneRepository.buscarPorValorS(letra,0));
        zoneRepository.asignarZonaEmpleado(letra, codigo);

        System.out.println("Empleado asignado exitosamente.");
    }

    private void quitarEmpleado() {
        System.out.println("=== Quitar de zona a empleado ===");
        
        System.out.println("Ingrese codigo de empleado: ");
        int codigo = EntradaCons.ingresaInt();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.listarEmpleadoZonas(employeeRepository.buscarPorValor(codigo,2));
                
        System.out.print("Ingrese letra de la zona que quiere quitar: ");
        String letra = EntradaCons.ingresaString();

        if(!zoneRepository.existePorValorS(letra,0)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        zoneRepository.quitarZonaEmpleado(letra, employeeRepository.buscarPorValor(codigo,2));
        employeeRepository.quitarEmpleadoZona(codigo, zoneRepository.buscarPorValorS(letra,0));
        
        System.out.println("Empleado asignado exitosamente.");
    }
}
