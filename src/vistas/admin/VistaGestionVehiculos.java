package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionVehiculos extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Vehiculos ===");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Modificar vehiculo");
        System.out.println("3. Eliminar vehiculo");
        System.out.println("0. Salir");
    }
    
}