package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import sherlockhomes.SocioRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;

public class AccionesAdminVehiculo {
    
    VehiculoRepositoryFile vehicleRepository;
    SocioRepositoryFile associatedRepository;

    public void ejecutar(Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> {
                System.out.println("=== Registro de Vehículo para Socio ===");

                System.out.print("Ingrese patente: ");
                String patente = sc.nextLine();
                
                if(vehicleRepository.existeVehiculoPorPatente(patente)){
                    System.out.print("Ya existe el vehiculo con patente " + patente + ".");
                    return;
                }

                System.out.print("Ingrese marca: ");
                String marca = sc.nextLine();

                System.out.print("Ingrese tipo de vehículo (Auto/Moto/Camioneta): ");
                String tipo = sc.nextLine();
                
                System.out.print("Ingrese Dimensiones: ");
                String dimensiones = sc.nextLine();
                
                System.out.print("Ingrese DNI propietario: ");
                int DNI = sc.nextInt();
                sc.nextLine();
                
                if(!associatedRepository.existeSocioPorDni(DNI)){
                    System.out.print("No existe el socio DNI " + DNI + ".");
                    return;
                }
                
                if(vehicleRepository.crearVehiculo(patente, marca, tipo, dimensiones, associatedRepository.buscarSocioPorDni(DNI))){
                    System.out.println("Se agregó el vehiculo exitosamente.");
                    vehicleRepository.mostrarVehiculoPorPatente(patente);
                } else {
                    System.out.println("Fallo carga de vehiculo.");
                }
            }
            case 2 -> {
                System.out.println("=== Eliminar Vehiculo ===");
                
                System.out.print("Ingrese patente a eliminar: ");
                String patente = sc.nextLine();
                
                if(!vehicleRepository.existeVehiculoPorPatente(patente)){
                    System.out.print("No existe el vehiculo con patente " + patente + ".");
                    return;
                }
                
                if(vehicleRepository.eliminarVehiculoPorPatente(patente)){
                    System.out.println("Se eliminó el vehiculo patente " + patente + ".");
                }
            }
            case 3 -> {
                vehicleRepository.listarVehiculosAll();
            }
            case 0 -> {
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
