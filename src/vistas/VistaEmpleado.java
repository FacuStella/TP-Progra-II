package vistas;

import vistas.Vista;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class VistaEmpleado extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Empleado ===");
        System.out.println("1. Consultar zonas asignadas");
        System.out.println("2. Consultar vehículos encargados");
        System.out.println("0. Salir");
    }
    
}