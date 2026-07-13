package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionGarages extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Garages ===");
        System.out.println("1. Agregar garage");
        System.out.println("2. Asignar vehiculo a garage");
        System.out.println("3. Quitar vehiculo asignado");
        System.out.println("4. Comprar garage");
        System.out.println("5. Mostrar todos");
        System.out.println("0. Salir");
    }
    
}