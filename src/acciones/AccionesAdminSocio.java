package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.EmpleadoRepositoryFile;
import sherlockhomes.SocioRepositoryFile;
import sherlockhomes.Usuario;
import sherlockhomes.UsuarioRepositoryFile;

public class AccionesAdminSocio {
    
    protected SocioRepositoryFile associatedRepository;

    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> {
                System.out.println("=== Registro de nuevo Socio ===");
                
                System.out.print("Ingrese Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese DNI: ");
                int DNI = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Ingrese direccion: ");
                String direccion = sc.nextLine();
                
                System.out.println("Ingrese telefono: ");
                String telefono = sc.nextLine();
                
                if(associatedRepository.crearSocio(nombre, DNI, direccion, telefono)){
                    System.out.println("Se agregó el socio exitosamente.");
                    associatedRepository.mostrarSocioPorDni(DNI);
                } else {
                    System.out.println("Fallo registro de socio.");
                }
            }
            case 2 -> {
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
            case 3 -> {
                System.out.println("=== Eliminar Socio ===");
                int DNI;
                
                System.out.println("Ingrese DNI: ");
                DNI = sc.nextInt();
                sc.nextLine();
                        
                associatedRepository.eliminarSocioPorDni(DNI);
                
                System.out.println("Se eliminó el socio DNI " + DNI + ".");
            }
            case 4 -> {
                associatedRepository.listarSociosAll();
            }
            case 0 -> {
                return;
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
