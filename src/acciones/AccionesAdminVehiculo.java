package acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import sherlockhomes.Socio;
import sherlockhomes.SocioUtils;
import sherlockhomes.Usuario;
import sherlockhomes.Vehiculo;
import sherlockhomes.VehiculoUtils;

public class AccionesAdminVehiculo {

    public void ejecutar(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, ArrayList<Vehiculo> vehiculos, Usuario usuario, int opc, Scanner sc) {
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
                
                System.out.print("Ingrese DNI propietario: ");
                int DNI = sc.nextInt();
                sc.nextLine();
                
                Socio socio = SocioUtils.buscarSocioPorDni(socios, DNI);
                
                if(socio == null){
                    System.out.print("No existe el socio DNI " + DNI + ".");
                    return;
                }
                
                Vehiculo vehiculo = new Vehiculo(patente, marca, tipo, dimensiones, socio);

                vehiculos.add(vehiculo);
                
                System.out.println("Se agregó el vehiculo al socio DNI " + DNI + " exitosamente.");
                return;
            }
            case 2 -> {
                System.out.println("=== Eliminar Vehiculo ===");
                
                Vehiculo vehiculo;
                
                System.out.print("Ingrese patente a eliminar: ");
                String patente = sc.nextLine();
                
                vehiculo = VehiculoUtils.buscarVehiculoPorPatente(vehiculos, patente);
                
                if(vehiculo == null){
                    System.out.print("Vehiculo no encontrado.");
                    return;
                }
                
                VehiculoUtils.eliminarVehiculo(vehiculos, vehiculo);
                
                System.out.println("Se eliminó el vehiculo patente " + vehiculo.getMatricula()+ ".");
            }
            case 3 -> {
                VehiculoUtils.listarVehiculos(vehiculos);
            }
            case 0 -> {
            }
            default -> {
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
