package sherlockhomes;

import java.util.Scanner;

public class MenuEmpleado extends Menu {

    @Override
    public void mostrarMenu() {
        System.out.println("=== Menú Empleado ===");
        System.out.println("1. Consultar zonas asignadas");
        System.out.println("2. Consultar vehículos encargados");
        System.out.println("0. Salir");
    }
    
    @Override
    protected void acciones(int tipo) {
        switch (tipo) {
            case 1 -> {
                 System.out.println("Se consultan zonas asignadas del empleado.");
            }
            case 2 -> {
                System.out.println("Se consultan vehiculos encargados del empleado.");
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