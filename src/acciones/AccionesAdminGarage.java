package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import sherlockhomes.GarageRepositoryFile;
import sherlockhomes.SocioRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminGarage {
    
    protected GarageRepositoryFile garageRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    protected SocioRepositoryFile asocciatedRepository;
    protected ZonaRepositoryFile zoneRepository;
    
    public AccionesAdminGarage(){
        garageRepository = new GarageRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
        asocciatedRepository = new SocioRepositoryFile();
        zoneRepository = new ZonaRepositoryFile();
    }

    public void ejecutar(Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarGarage(sc); 
            case 2 -> quitarGarageVehiculo(sc);
            case 3 -> asignarGarageVehiculo(sc);
            case 4 -> comprarGarage(sc);
            case 5 -> garageRepository.listarGaragesAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }

    private void registrarGarage(Scanner sc) {
        System.out.println("=== Registro de garage ===");
        
        System.out.print("Ingrese zona donde se agrega el garage: ");
        String letra = sc.nextLine();

        if(!zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("No existe la zona.");
            return;
        }

        if(garageRepository.crearGarage(zoneRepository.buscarZonaPorLetra(letra))){
            System.out.println("Se agregó el garage exitosamente.");
            //garageRepository.mostrarGaragePorNumero(patente);
        } else {
            System.out.println("Fallo carga de garage.");
        }
    }

    private void quitarGarageVehiculo(Scanner sc) {
        System.out.println("=== Quitar garage a vehiculo ===");

        System.out.println("Ingrese numero: ");
        int numero = sc.nextInt();
        sc.nextLine();
        
        if(!garageRepository.existeGaragePorNumero(numero)){
            System.out.println("El garage no existe.");
            return;
        }
        
        if(!garageRepository.tieneVehiculoAsignado(numero)){
            System.out.println("El garage no tiene vehiculo asignado.");
            return;
        }
        
        vehicleRepository.quitarGarageVehiculo(numero);
        garageRepository.quitarGarageVehiculo(numero);  
    }

    private void asignarGarageVehiculo(Scanner sc) {
        System.out.println("=== Asignar garage a vehículo===");
        
        System.out.println("Ingrese numero gge: ");
        int numero = sc.nextInt();
        sc.nextLine();
        
        if(!garageRepository.existeGaragePorNumero(numero)){
            System.out.println("El garage no existe.");
            return;
        }

        asocciatedRepository.listarSocioVehiculos(garageRepository.buscarGaragePorNumero(numero).getPropietario());
        
        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("El vehiculo no existe.");
            return;
        }
        
        if(garageRepository.tieneVehiculoAsignado(numero)){
            garageRepository.quitarGarageVehiculo(numero);
        }
        
        garageRepository.asignarGarageVehiculo(numero,patente);
        vehicleRepository.asignarVehiculoGarage(patente,numero);
    }

    private void comprarGarage(Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
