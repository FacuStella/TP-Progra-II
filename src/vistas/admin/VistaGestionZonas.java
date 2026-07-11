package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionZonas extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Zonas ===");
        System.out.println("1. Agregar");
        System.out.println("2. Asignar empleado");
        System.out.println("3. Quitar empleado");
        System.out.println("4. Mostrar todas");
        System.out.println("0. Salir");
    }
    
}