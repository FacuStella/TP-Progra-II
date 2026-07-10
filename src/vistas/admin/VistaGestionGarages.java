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
        System.out.println("2. Modificar garage");
        System.out.println("3. Eliminar garage");
        System.out.println("0. Salir");
    }
    
}