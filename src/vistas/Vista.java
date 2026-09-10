package vistas;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import sherlockhomes.Empleado;
import sherlockhomes.Socio;
import sherlockhomes.Usuario;

public class Vista {

    public Vista() {
    }
    
    public void mostrarMenu(Usuario administrador) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Administrador ===");
        System.out.println("1. Gestionar socios");
        System.out.println("2. Gestionar vehículos");
        System.out.println("3. Gestionar garages");
        System.out.println("4. Gestionar zonas");
        System.out.println("5. Gestionar empleados");
        System.out.println("0. Salir");
    }
    
    public void mostrarMenu(Socio socio) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Socio ===");
        System.out.println("1. Consultar vehículos");
        System.out.println("2. Consultar garages");
        System.out.println("0. Salir");
    }
    
    public void mostrarMenu(Empleado empleado) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Empleado ===");
        System.out.println("1. Consultar zonas asignadas");
        System.out.println("2. Consultar vehículos asignados");
        System.out.println("0. Salir");
    }

    public void salir(){
        System.out.println("Gracias vuelva prontos.");
    }

    public void noReconocida(){
        System.out.println("Opcion no reconocida");
    }   
}