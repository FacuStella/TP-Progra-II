package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import sherlockhomes.Usuario;
import sherlockhomes.VehiculoRepositoryFile;
import sherlockhomes.ZonaRepositoryFile;

public class AccionesAdminZona {
    
    protected ZonaRepositoryFile zoneRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    
    public AccionesAdminZona(){
        zoneRepository = new ZonaRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
    }

    public void ejecutar(Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarZona(sc); 
            case 2 -> asignarEmpleado(sc);
            case 3 -> quitarEmpleado(sc);
            case 4 -> zoneRepository.listarZonasAll();
            case 0 -> {}
            default -> {}
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void quitarEmpleado(Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
