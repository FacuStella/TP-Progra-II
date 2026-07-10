package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Socio;
import sherlockhomes.SocioUtils;
import sherlockhomes.Usuario;
import sherlockhomes.UsuarioUtils;

public class AccionesAdminSocio {

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
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
                
                System.out.println("Se agregó el socio " + DNI + " exitosamente.");
                return;
            }
            case 2 -> {
                System.out.println("=== Modificar Socio ===");
                
                Socio socio;
                
                socio = buscarSocioPorDni(socios, sc);
                
                if(socio == null){
                    System.out.print("Socio no encontrado.");
                    return;
                }
                
                System.out.print("Modificar direccion o vacio: ");
                String direccion = sc.nextLine();
                
                System.out.print("Modificar Telefono o vacio: ");
                String telefono = sc.nextLine();
                
                if(!direccion.isBlank()){socio.setDireccion(direccion);}
                if(!direccion.isBlank()){socio.setTelefono(telefono);}
                
                System.out.println("Se modificó el socio DNI " + socio.getDNI() + ".");
            }
            case 3 -> {
                System.out.println("=== Eliminar Socio ===");
                
                Socio socio;
                
                socio = buscarSocioPorDni(socios, sc);
                
                if(socio == null){
                    System.out.print("Socio no encontrado.");
                    return;
                }
                
                SocioUtils.eliminarSocio(socios, socio);
                UsuarioUtils.eliminarUsuario(usuarios, socio);
                
                System.out.println("Se eliminó el socio DNI " + socio.getDNI() + ".");
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

    public Socio buscarSocioPorDni(ArrayList<Socio> socios, Scanner sc) {
        System.out.print("Ingrese DNI de Socio: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        return SocioUtils.buscarSocioPorDni(socios, DNI);   
    }
}
