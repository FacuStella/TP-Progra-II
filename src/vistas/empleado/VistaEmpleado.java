package vistas.empleado;

import vistas.Vista;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaEmpleado extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Empleado ===");
        System.out.println("1. Consultar zonas asignadas");
        System.out.println("2. Consultar vehículos asignados");
        System.out.println("0. Salir");
    }
    
}