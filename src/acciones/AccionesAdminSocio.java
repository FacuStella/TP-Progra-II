package acciones;

import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Socio;
import sherlockhomes.SocioUtils;
import sherlockhomes.Usuario;

public class AccionesAdminSocio {

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, Usuario usuarioLogueado, int opc, Scanner sc) {

        switch (opc) {
            case 1 -> {
                System.out.println("=== Registro de nuevo Socio ===");
                
                 System.out.print("Ingrese Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese DNI: ");
                int DNI = sc.nextInt();
                sc.nextLine();
                
                if(SocioUtils.buscarSocioPorDni(socios, DNI) != null){
                    System.out.print("Ya existe el socio DNI " + DNI + ".");
                    return;
                }
                
                System.out.print("Ingrese direccion: ");
                String direccion = sc.nextLine();
                
                System.out.print("Ingrese Telefono: ");
                String telefono = sc.nextLine();
                
                Socio socio = new Socio(nombre, DNI, direccion, telefono, nombre+"Soc",String.format("%04d", DNI % 10000));

                socios.add(socio);
                usuarios.add(socio);
                
                System.out.print("Se agregó el socio " + DNI + " exitosamente.");
                return;
            }
            case 2 -> {
                System.out.println("Se modifica socio.");
            }
            case 3 -> {
                System.out.println("Se elimina socio.");
            }
            case 4 -> {
                SocioUtils.listarSocios(socios);
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
