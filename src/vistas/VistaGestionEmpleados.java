package vistas;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class VistaGestionEmpleados extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Empleados ===");
        System.out.println("1. Agregar garage");
        System.out.println("2. Modificar garage");
        System.out.println("2. Eliminar garage");
        System.out.println("0. Salir");
    }
    
}