package com.sherlockhomes.acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import com.sherlockhomes.model.Socio;
import com.sherlockhomes.model.SocioRepositoryFile;
import com.sherlockhomes.model.Usuario;

public class AccionesAdminSocio {
    
    protected SocioRepositoryFile associatedRepository;
    
    public AccionesAdminSocio(){
        associatedRepository = new SocioRepositoryFile();
    }
    
    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrar(sc);
            case 2 -> modificar(sc);
            case 3 -> eliminar(sc);
            case 4 -> listarSocioVehiculos(sc);
            case 5 -> listarSocioGarages(sc);
            case 6 -> associatedRepository.listarAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }
    
    public void registrar(Scanner sc) {
        System.out.println("=== Registro de nuevo Socio ===");

        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();
        
        if(associatedRepository.existePorValor(DNI,0)){
            System.out.println("Socio ya existe.");
            return;
        }

        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = sc.nextLine();

        try{ 
            Socio aux = new Socio(nombre, DNI, direccion, telefono);
            associatedRepository.crear(aux);
            System.out.println("Se agregó el socio exitosamente.");
            associatedRepository.mostrarPorValor(DNI,0);
        } catch(Exception e) {
            System.out.println("Fallo registro de socio." + e.getMessage());
        }
    }

    public void modificar(Scanner sc) {
        System.out.println("=== Modificar Socio ===");
                
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existePorValor(DNI,0)){
            System.out.println("Socio no encontrado.");
            return;
        }

        System.out.println("Modificar direccion o vacio: ");
        String direccion = sc.nextLine();

        System.out.println("Modificar telefono o vacio: ");
        String telefono = sc.nextLine();
        
        Socio aux = new Socio("", DNI, direccion, telefono);
        associatedRepository.modificarPorValor(DNI,0, aux);

        System.out.println("Se modificó el socio DNI " + DNI + ".");
    }

    public void eliminar(Scanner sc) {
        System.out.println("=== Eliminar Socio ===");
        
        int DNI;

        System.out.println("Ingrese DNI: ");
        DNI = sc.nextInt();
        sc.nextLine();
        
        if(!associatedRepository.existePorValor(DNI,0)){
            System.out.println("Socio no encontrado.");
            return;
        }

        associatedRepository.eliminarPorValor(DNI,0);

        System.out.println("Se eliminó el socio DNI " + DNI + ".");
    }

    private void listarSocioVehiculos(Scanner sc) {
        System.out.println("=== Muestra vehiculos de un socio ===");
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existePorValor(DNI,0)){
            System.out.println("Socio no encontrado.");
            return;
        }
        
        associatedRepository.listarSocioVehiculos(associatedRepository.buscarPorValor(DNI,0));
    }
    
    private void listarSocioGarages(Scanner sc) {
        System.out.println("=== Muestra garages de un socio ===");
        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(!associatedRepository.existePorValor(DNI,0)){
            System.out.println("Socio no encontrado.");
            return;
        }
        
        associatedRepository.listarSocioGarages(associatedRepository.buscarPorValor(DNI,0));
    }
}
