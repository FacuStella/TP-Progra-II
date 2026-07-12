package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionEmpleados extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Empleados ===");
        System.out.println("1. Agregar");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Asignar zona");
        System.out.println("5. Asignar vehiculo");
        System.out.println("6. Mostrar vehiculos de empleado");
        System.out.println("7. Mostrar todos");
        System.out.println("0. Salir");
    }
    
}