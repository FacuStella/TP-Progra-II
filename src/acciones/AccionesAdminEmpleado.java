package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.EmpleadoRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminEmpleado {
    
    protected EmpleadoRepositoryFile employeeRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    protected ZonaRepositoryFile zoneRepository;
    
    public AccionesAdminEmpleado(){
        employeeRepository = new EmpleadoRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
        zoneRepository = new ZonaRepositoryFile();
    }

    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarEmpleado(sc);
            case 2 -> modificarEmpleado(sc);
            case 3 -> eliminarEmpleado(sc);
            case 4 -> asignarEmpleadoZona(sc);
            case 5 -> quitarEmpleadoZona(sc);
            case 6 -> listarEmpleadoZonas(sc);
            case 7 -> asignarVehiculoEmpleado(sc);
            case 8 -> quitarEmpleadoVehiculo(sc);
            case 9 -> listarEmpleadoVehiculos(sc);
            case 10 -> employeeRepository.listarEmpleadosAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }

    public int menuBusquedaEmpleado(Scanner sc) {
        System.out.println("Ingrese clave por la que desea buscar al empleado.");
        System.out.println("1. Por DNI");
        System.out.println("2. Por codigo");
        int opcion = sc.nextInt();
        sc.nextLine();
            
        return opcion;
    }

    private void registrarEmpleado(Scanner sc) {
        System.out.println("=== Registro de nuevo Empleado ===");

        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(employeeRepository.existeEmpleadoPorDni(DNI)){
            System.out.println("Ya existe empleado con DNI " + DNI + ".");
            return;
        }

        System.out.print("Ingrese direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Ingrese Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Ingrese Especialidad: ");
        String especialidad = sc.nextLine();
        
        try{
            employeeRepository.crearEmpleado(nombre, DNI, direccion, telefono, especialidad);
            System.out.println("Se agregó el empleado exitosamente.");
            employeeRepository.mostrarEmpleadoPorDni(DNI);
        } catch(Exception e) {
            System.out.println("Fallo registro de empleado." + e.getMessage());
        }
    }

    private void modificarEmpleado(Scanner sc) {
        System.out.println("=== Modificar Empleado ===");
                
        int buscarPor = menuBusquedaEmpleado(sc);
        int aux;
        switch(buscarPor){
            case 1 -> {
                System.out.println("Ingrese DNI: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(!employeeRepository.existeEmpleadoPorDni(aux)){
                    System.out.println("Empleado no encontrado.");
                    return;
                }
            }
            case 2 ->{
                System.out.println("Ingrese codigo: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(!employeeRepository.existeEmpleadoPorCodigo(aux)){
                    System.out.println("Empleado no encontrado.");
                    return;
                }
            }
            default -> {
                return;
            }
        }

        System.out.print("Modificar direccion o vacio: ");
        String direccion = sc.nextLine();

        System.out.print("Modificar telefono o vacio: ");
        String telefono = sc.nextLine();

        System.out.print("Modificar especialidad o vacio: ");
        String especialidad = sc.nextLine();

        switch(buscarPor){
            case 1 -> {
                    employeeRepository.modificarEmpleadoPorDni(aux, direccion, telefono, especialidad);
                    System.out.println("Se modificó existosamente el empleado.");
                    employeeRepository.mostrarEmpleadoPorDni(aux);
            }
            case 2 ->{
                    employeeRepository.modificarEmpleadoPorCodigo(aux, direccion, telefono, especialidad);
                    System.out.println("Se modificó existosamente el empleado.");
                    employeeRepository.mostrarEmpleadoPorCodigo(aux);
            }
            default -> {}
        }
    }

    private void eliminarEmpleado(Scanner sc) {
        System.out.println("=== Eliminar Empleado ===");
        boolean eliminado = false;
        int aux;
        switch(menuBusquedaEmpleado(sc)){
            case 1 -> {
                System.out.println("Ingrese DNI: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorDni(aux)){
                    eliminado = employeeRepository.eliminarEmpleadoPorDni(aux);
                }
            }
            case 2 ->{
                System.out.println("Ingrese codigo: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorCodigo(aux)){
                    eliminado = employeeRepository.eliminarEmpleadoPorCodigo(aux);
                }
            }
            default -> {
                return;
            }
        }
        if(eliminado){
            System.out.println("Se eliminó el empleado exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar el empleado.");
        }
    }

    private void asignarEmpleadoZona(Scanner sc) {
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
        
        zoneRepository.asignarZonaEmpleado(letra, codigo);
        employeeRepository.asignarEmpleadoZona(codigo, zoneRepository.buscarZonaPorLetra(letra));
        
        System.out.println("Empleado asignado exitosamente.");
    }

    private void asignarVehiculoEmpleado(Scanner sc) {
        System.out.println("=== Asignar vehículo a empleado ===");
        
        employeeRepository.listarEmpleadosAll();
        
        System.out.println("Ingrese codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existeEmpleadoPorCodigo(codigo)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        vehicleRepository.listarVehiculosAll();
        
        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("El vehiculo no existe.");
            return;
        }
        
        if(vehicleRepository.tieneEmpleadoAsignado(patente)){
            vehicleRepository.quitarVehiculoEmpleado(patente);
        }
        
        vehicleRepository.asignarVehiculoEmpleado(patente,employeeRepository.buscarEmpleadoPorCodigo(codigo));
        employeeRepository.asignarEmpleadoVehiculo(codigo,vehicleRepository.buscarVehiculoPorPatente(patente));
        // falta modificar el objeto VehiculoAsignado de Garage
    }

    private void listarEmpleadoVehiculos(Scanner sc) {
        int aux;
        switch(menuBusquedaEmpleado(sc)){
            case 1 -> {
                System.out.println("Ingrese DNI: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorDni(aux)){
                    employeeRepository.listarEmpleadoVehiculos(employeeRepository.buscarEmpleadoPorDni(aux));
                }
            }
            case 2 ->{
                System.out.println("Ingrese codigo: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorCodigo(aux)){
                    employeeRepository.listarEmpleadoVehiculos(employeeRepository.buscarEmpleadoPorCodigo(aux));
                }
            }
            default -> {
                return;
            }
        }
    }
    
    private void listarEmpleadoZonas(Scanner sc) {
        int aux;
        switch(menuBusquedaEmpleado(sc)){
            case 1 -> {
                System.out.println("Ingrese DNI: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorDni(aux)){
                    employeeRepository.listarEmpleadoZonas(employeeRepository.buscarEmpleadoPorDni(aux));
                }
            }
            case 2 ->{
                System.out.println("Ingrese codigo: ");
                aux = sc.nextInt();
                sc.nextLine();
                if(employeeRepository.existeEmpleadoPorCodigo(aux)){
                    employeeRepository.listarEmpleadoZonas(employeeRepository.buscarEmpleadoPorCodigo(aux));
                }
            }
            default -> {
                return;
            }
        }
    }

    private void quitarEmpleadoZona(Scanner sc) {
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
        
        System.out.println("Empleado desasignado exitosamente.");
    }

    private void quitarEmpleadoVehiculo(Scanner sc) {
        System.out.println("=== Quitar vehiculo a empleado ===");
        
        System.out.println("Ingrese codigo de empleado: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existeEmpleadoPorCodigo(codigo)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.listarEmpleadoVehiculos(employeeRepository.buscarEmpleadoPorCodigo(codigo));
                
        System.out.print("Ingrese patente a quitar: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("No existe vehiculo.");
            return;
        }
        
        vehicleRepository.quitarVehiculoEmpleado(patente);
        employeeRepository.quitarEmpleadoVehiculo(codigo, vehicleRepository.buscarVehiculoPorPatente(patente));
        
        System.out.println("Vehiculo desasignado exitosamente.");
    }
     
}
