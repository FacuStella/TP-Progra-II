package vistas.socio;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import vistas.Vista;

public class VistaSocio extends Vista {

    @Override
    protected void mostrarMenu(){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("=== Menú Socio ===");
        System.out.println("1. Consultar vehículos");
        System.out.println("2. Consultar garages");
        System.out.println("0. Salir");
    }
    
}