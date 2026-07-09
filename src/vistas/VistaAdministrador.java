package vistas;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class VistaAdministrador extends Vista {
    
    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Administrador ===");
        System.out.println("1. Gestionar socios");
        System.out.println("2. Gestionar vehículos");
        System.out.println("3. Gestionar garages");
        System.out.println("4. Gestionar zonas");
        System.out.println("5. Gestionar empleados");
        System.out.println("0. Salir");
    }
    
}