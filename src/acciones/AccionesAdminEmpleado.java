package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Empleado;
import sherlockhomes.EmpleadoRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminEmpleado {
    
    protected EmpleadoRepositoryFile employeeRepository;
    protected ZonaRepositoryFile zoneRepository;

    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> {
                System.out.println("=== Registro de nuevo Empleado ===");
                
                System.out.print("Ingrese Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese DNI: ");
                int DNI = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Ingrese direccion: ");
                String direccion = sc.nextLine();
                
                System.out.print("Ingrese Telefono: ");
                String telefono = sc.nextLine();
                
                System.out.print("Ingrese Especialidad: ");
                String especialidad = sc.nextLine();
                
                if(employeeRepository.crearEmpleado(nombre, DNI, direccion, telefono, especialidad)){
                    System.out.println("Se agregó el empleado exitosamente.");
                    employeeRepository.mostrarEmpleadoPorDni(DNI);
                } else {
                    System.out.println("Fallo registro de empleado.");
                }
            }
            case 2 -> {
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
                        if(employeeRepository.modificarEmpleadoPorDni(aux, direccion, telefono, especialidad)){
                            System.out.println("Se modificó existosamente el empleado.");
                            employeeRepository.mostrarEmpleadoPorDni(aux);
                        };
                    }
                    case 2 ->{
                        if(employeeRepository.modificarEmpleadoPorCodigo(aux, direccion, telefono, especialidad)){
                            System.out.println("Se modificó existosamente el empleado.");
                            employeeRepository.mostrarEmpleadoPorCodigo(aux);
                        };
                    }
                    default -> {
                        return;
                    }
                }
            }
            case 3 -> {
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
            case 4 -> {
                System.out.println("=== Asignar zona a empleado ===");
                
                System.out.print("Ingrese letra de la zona que quiere asignar: ");
                String letra = sc.nextLine();

                if(!zoneRepository.existeZonaPorLetra(letra)){
                    System.out.println("No existe la zona con letra " + letra + ".");
                    return;
                }
                int aux;
                switch(menuBusquedaEmpleado(sc)){
                    case 1 -> {
                        System.out.println("Ingrese DNI: ");
                        aux = sc.nextInt();
                        sc.nextLine();
                        if(employeeRepository.existeEmpleadoPorDni(aux)){
                            employeeRepository.asignarEmpleadoZona(employeeRepository.buscarEmpleadoPorDni(aux), zoneRepository.buscarZonaPorLetra(letra));
                        }
                    }
                    case 2 ->{
                        System.out.println("Ingrese codigo: ");
                        aux = sc.nextInt();
                        sc.nextLine();
                        if(employeeRepository.existeEmpleadoPorCodigo(aux)){
                            employeeRepository.asignarEmpleadoZona(employeeRepository.buscarEmpleadoPorCodigo(aux), zoneRepository.buscarZonaPorLetra(letra));
                        }
                    }
                    default -> {
                        return;
                    }
                }
            }
            case 5 -> {
                System.out.println("Se asignan vehiculos al empleado.");
            }
            case 6 -> {
                employeeRepository.listarEmpleadosAll();
            }
            case 0 -> {
                return;
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
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
     
}
