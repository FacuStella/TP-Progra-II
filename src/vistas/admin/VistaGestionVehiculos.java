package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionVehiculos extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Vehiculos ===");
        System.out.println("1. Agregar");
        System.out.println("2. Asignar garage");
        System.out.println("3. Quitar garage");
        System.out.println("4. Eliminar");
        System.out.println("5. Mostrar todos");
        System.out.println("0. Salir");
    }
    
}