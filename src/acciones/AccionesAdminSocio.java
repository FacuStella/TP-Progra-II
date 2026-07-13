package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.SocioRepositoryFile;
import sherlockhomes.Usuario;

public class AccionesAdminSocio {
    
    protected SocioRepositoryFile associatedRepository;
    
    public AccionesAdminSocio(){
        associatedRepository = new SocioRepositoryFile();
    }
    
    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarSocio(sc);
            case 2 -> modificarSocio(sc);
            case 3 -> eliminarSocio(sc);
            case 4 -> listarSocioVehiculos(sc);
            case 5 -> listarSocioGarages(sc);
            case 6 -> associatedRepository.listarSociosAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }
    
    public void registrarSocio(Scanner sc) {
        System.out.println("=== Registro de nuevo Socio ===");

        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();
        
        if(associatedRepository.existeSocioPorDni(DNI)){
            System.out.println("Socio ya existe.");
            return;
        }

        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = sc.nextLine();

        try{ 
            associatedRepository.crearSocio(nombre, DNI, direccion, telefono);
            System.out.println("Se agregó el socio exitosamente.");
            associatedRepository.mostrarSocioPorDni(DNI);
        } catch(Exception e) {
            System.out.println("Fallo registro de socio." + e.getMessage());
        }
    }

    public void modificarSocio(Scanner sc) {
        System.out.println("=== Modificar Socio ===");
                
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existeSocioPorDni(DNI)){
            System.out.println("Socio no encontrado.");
            return;
        }

        System.out.println("Modificar direccion o vacio: ");
        String direccion = sc.nextLine();

        System.out.println("Modificar telefono o vacio: ");
        String telefono = sc.nextLine();

        associatedRepository.modificarSocioPorDni(DNI, direccion, telefono);

        System.out.println("Se modificó el socio DNI " + DNI + ".");
    }

    public void eliminarSocio(Scanner sc) {
        System.out.println("=== Eliminar Socio ===");
        
        int DNI;

        System.out.println("Ingrese DNI: ");
        DNI = sc.nextInt();
        sc.nextLine();

        associatedRepository.eliminarSocioPorDni(DNI);

        System.out.println("Se eliminó el socio DNI " + DNI + ".");
    }

    private void listarSocioVehiculos(Scanner sc) {
        System.out.println("=== Muestra vehiculos de un socio ===");
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existeSocioPorDni(DNI)){
            System.out.println("Socio no encontrado.");
            return;
        }
        
        associatedRepository.listarSocioVehiculos(associatedRepository.buscarSocioPorDni(DNI));
    }
    
    private void listarSocioGarages(Scanner sc) {
        System.out.println("=== Muestra garages de un socio ===");
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existeSocioPorDni(DNI)){
            System.out.println("Socio no encontrado.");
            return;
        }
        
        associatedRepository.listarSocioGarages(associatedRepository.buscarSocioPorDni(DNI));
    }
}
