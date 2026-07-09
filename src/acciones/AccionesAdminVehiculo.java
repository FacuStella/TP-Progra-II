package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Socio;
import sherlockhomes.SocioUtils;
import sherlockhomes.Usuario;

public class AccionesAdminVehiculo {

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, Usuario usuario, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> {
                System.out.println("=== Registro de Vehículo para Socio ===");

                System.out.print("Ingrese patente: ");
                String patente = sc.nextLine();

                System.out.print("Ingrese marca: ");
                String marca = sc.nextLine();

                System.out.print("Ingrese tipo de vehículo (Auto/Moto/Camioneta): ");
                String tipo = sc.nextLine();
                
                System.out.print("Ingrese Dimensiones: ");
                String dimensiones = sc.nextLine();
                
                System.out.print("Ingrese DNI Propietario: ");
                int DNI = sc.nextInt();
                sc.nextLine();
            }
            case 2 -> {
                System.out.println("Se modifica vehiculo.");
            }
            case 3 -> {
                System.out.println("Se elimina vehiculo.");
            }
            case 0 -> {
                System.out.println("Gracias vuelva prontos.");
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
