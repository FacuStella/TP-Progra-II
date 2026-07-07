package sherlockhomes;

import java.util.Scanner;

public class MenuSocio extends Menu {
    
    @Override
    protected void mostrarMenu(){
        System.out.println("=== Menú Socio ===");
        System.out.println("1. Consultar vehículos");
        System.out.println("2. Consultar garages");
        System.out.println("0. Salir");
    }
    
}