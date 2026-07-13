package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import sherlockhomes.EmpleadoRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminZona {
    
    ZonaRepositoryFile zoneRepository;
    VehiculoRepositoryFile vehicleRepository;
    EmpleadoRepositoryFile employeeRepository;
    
    public AccionesAdminZona(){
        zoneRepository = new ZonaRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
        employeeRepository = new EmpleadoRepositoryFile();
    }

    public void ejecutar(Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarZona(sc); 
            case 2 -> asignarEmpleado(sc);
            case 3 -> quitarEmpleado(sc);
            case 4 -> zoneRepository.listarZonasAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }

    private void registrarZona(Scanner sc) {
        System.out.println("=== Registro de Zona ===");
        
        System.out.print("Ingrese zona: ");
        String letra = sc.nextLine();

        if(zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("La zona ya existe.");
            return;
        }
    }


    private void asignarEmpleado(Scanner sc) {
        System.out.println("=== Asignar zona a empleado ===");
                
        System.out.print("Ingrese letra de la zona que quiere asignar: ");
        String letra = sc.nextLine();

        if(!zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        System.out.println("Ingrese codigo de empleado a asignar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existeEmpleadoPorCodigo(codigo)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.asignarEmpleadoZona(codigo, zoneRepository.buscarZonaPorLetra(letra));
        zoneRepository.asignarZonaEmpleado(letra, codigo);

        System.out.println("Empleado asignado exitosamente.");
    }

    private void quitarEmpleado(Scanner sc) {
        System.out.println("=== Quitar de zona a empleado ===");
        
        System.out.println("Ingrese codigo de empleado: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existeEmpleadoPorCodigo(codigo)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.listarEmpleadoZonas(employeeRepository.buscarEmpleadoPorCodigo(codigo));
                
        System.out.print("Ingrese letra de la zona que quiere quitar: ");
        String letra = sc.nextLine();

        if(!zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        zoneRepository.quitarZonaEmpleado(letra, employeeRepository.buscarEmpleadoPorCodigo(codigo));
        employeeRepository.quitarEmpleadoZona(codigo, zoneRepository.buscarZonaPorLetra(letra));
        
        System.out.println("Empleado asignado exitosamente.");
    }
}
