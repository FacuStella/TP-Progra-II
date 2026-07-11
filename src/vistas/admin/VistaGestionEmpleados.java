package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionEmpleados extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Empleados ===");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Modificar empleado");
        System.out.println("3. Eliminar empleado");
        System.out.println("4. Asignar zona");
        System.out.println("5. Asignar vehiculo");
        System.out.println("6. Listar empleados");
        System.out.println("0. Salir");
    }
    
}