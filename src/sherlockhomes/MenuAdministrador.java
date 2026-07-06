package sherlockhomes;

import java.util.Scanner;

public class MenuAdministrador extends Menu {
    
    @Override
    public void mostrarMenu() {
        System.out.println("=== Menú Administrador ===");
        System.out.println("1. Gestionar socios");
        System.out.println("2. Gestionar vehículos");
        System.out.println("3. Gestionar garages");
        System.out.println("4. Gestionar zonas");
        System.out.println("5. Gestionar empleados");
        System.out.println("0. Salir");
    }
    
    @Override
    protected void acciones(int tipo) {
        switch (tipo) {
            case 1 -> {
                 System.out.println("Se gestionan socios.");
            }
            case 2 -> {
                System.out.println("Se gestionan vehiculos.");
            }
            case 3 -> {
                System.out.println("Se gestionan garages.");
            }
            case 4 -> {
                System.out.println("Se gestionan zonas.");
            }
            case 5 -> {
                System.out.println("Se gestionan empleados.");
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