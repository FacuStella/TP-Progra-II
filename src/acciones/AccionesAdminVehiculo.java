package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import sherlockhomes.GarageRepositoryFile;
import sherlockhomes.SocioRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;

public class AccionesAdminVehiculo {
    
    VehiculoRepositoryFile vehicleRepository;
    SocioRepositoryFile associatedRepository;
    GarageRepositoryFile garageRepository;
    
    public AccionesAdminVehiculo(){
        vehicleRepository = new VehiculoRepositoryFile();
        associatedRepository = new SocioRepositoryFile();
        garageRepository = new GarageRepositoryFile();
    }

    public void ejecutar(Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarVehiculo(sc);
            case 2 -> asignarVehiculoGarage(sc);
            case 3 -> quitarVehiculoGarage(sc);
            case 4 -> eliminarVehiculo(sc);
            case 5 -> vehicleRepository.listarVehiculosAll();
            case 0 -> {}
            default -> {}
        }
    }

    public void registrarVehiculo(Scanner sc) {
        System.out.println("=== Registro de vehículo para socio ===");

        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("Ya existe el vehiculo con patente " + patente + ".");
            return;
        }

        System.out.println("Ingrese marca: ");
        String marca = sc.nextLine();

        System.out.println("Ingrese tipo de vehículo (Auto/Moto/Camioneta): ");
        String tipo = sc.nextLine();

        System.out.println("Ingrese Dimensiones: ");
        String dimensiones = sc.nextLine();

        System.out.println("Ingrese DNI propietario: ");
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
    
    public void asignarVehiculoGarage(Scanner sc) {
        System.out.println("=== Asignar vehículo a garage ===");

        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("El vehiculo no existe.");
            return;
        }
        
        associatedRepository.listarSocioGarages(vehicleRepository.buscarVehiculoPorPatente(patente).getPropietario());
        
        System.out.println("Ingrese numero gge: ");
        int numero = sc.nextInt();
        sc.nextLine();

        if(!garageRepository.existeGaragePorNumero(numero)){
            System.out.println("El garage no existe.");
            return;
        }
        
        if(vehicleRepository.tieneGarageAsignado(patente)){
            vehicleRepository.quitarVehiculoGarage(patente);
        }
        
        garageRepository.asignarGarageVehiculo(numero,patente);
        vehicleRepository.asignarVehiculoGarage(patente,numero);
    }

    public void quitarVehiculoGarage(Scanner sc) {
        System.out.println("=== Quitar vehículo a garage ===");

        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("El vehiculo no existe.");
            return;
        }
        
        if(!vehicleRepository.tieneGarageAsignado(patente)){
            System.out.println("El vehiculo no tiene garage asignado.");
            return;
        }
        
        garageRepository.quitarVehiculoGarage(patente);
        vehicleRepository.quitarVehiculoGarage(patente);
    }

    public void eliminarVehiculo(Scanner sc) {
        System.out.println("=== Eliminar Vehiculo ===");
                
        System.out.print("Ingrese patente a eliminar: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("No existe el vehiculo con patente " + patente + ".");
            return;
        }

        if(vehicleRepository.eliminarVehiculoPorPatente(patente)){
            System.out.println("Se eliminó el vehiculo patente " + patente + ".");
        }
    }


}
