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
            case 2 -> asignarGarageVehiculo(sc);
            case 3 -> quitarGarageVehiculo(sc);
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
        
        try{
            garageRepository.crearGarage(zoneRepository.buscarZonaPorLetra(letra));
            System.out.println("Se agregó el garage exitosamente.");
            //garageRepository.mostrarGaragePorNumero(patente);
        } catch(Exception e) {
            System.out.println("Error inesperado al crear el garage" + e.getMessage());
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
        
        if(!garageRepository.tienePropietario(numero)){
            System.out.println("El garage no tiene propietario, por tanto no puede asignarse.");
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
        System.out.println("=== Venta de garage ===");
        
        System.out.println("Ingrese numero gge: ");
        int numero = sc.nextInt();
        sc.nextLine();
        
        if(!garageRepository.existeGaragePorNumero(numero)){
            System.out.println("El garage no existe.");
            return;
        }
        
        if(garageRepository.tienePropietario(numero)){
            System.out.println("El garage tiene propietario, por tanto no puede comprarse.");
            return;
        }
        
        System.out.println("Ingrese DNI del socio que compra: ");
        int DNI = sc.nextInt();
        sc.nextLine();
        
        if(!asocciatedRepository.existeSocioPorDni(DNI)){
            System.out.println("El socio no existe.");
            return;
        }
        
        asocciatedRepository.comprarGarage(DNI,garageRepository.buscarGaragePorNumero(numero));
        garageRepository.comprarGarage(numero,asocciatedRepository.buscarSocioPorDni(DNI));
    }
}
