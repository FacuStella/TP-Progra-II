package vistas.admin;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaGestionSocios extends Vista {

    @Override
    public void mostrarMenu() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Acciones sobre Socios ===");
        System.out.println("1. Agregar socio");
        System.out.println("2. Modificar socio");
        System.out.println("3. Eliminar socio");
        System.out.println("4. Consultar socios");
        System.out.println("0. Salir");
    }
    
}