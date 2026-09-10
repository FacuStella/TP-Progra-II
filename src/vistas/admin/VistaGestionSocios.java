package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class VistaGestionSocios extends VistaGestion {

    public VistaGestionSocios() {
    }

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Socios ===");
        System.out.println("1. Agregar");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Mostrar vehiculos");
        System.out.println("5. Mostrar garages");
        System.out.println("6. Mostrar todos");
        System.out.println("0. Salir");
    }
    
}