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
    
    @Override
    protected void acciones(int tipo) {
        switch (tipo) {
            case 1 -> {
                 System.out.println("Se consultan vehiculos del socio.");
            }
            case 2 -> {
                System.out.println("Se consultan garages del socio.");
            }
            case 0 -> {
                System.out.println("Gracias vuelva prontos.");
            }
            default ->{
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}