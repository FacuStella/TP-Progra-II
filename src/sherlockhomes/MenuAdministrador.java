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
    
}