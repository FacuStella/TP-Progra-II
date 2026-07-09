package vistas;

import java.util.Scanner;

public class Vista {
    
    public int ingresaInt(Scanner sc){
        String input;
        int opcion = -1;
        
        input = sc.nextLine();

        if (input.matches("\\d{1}")) {
            opcion = Integer.parseInt(input);
        }   
        
        return opcion;
    }
    
    public void mostrarMenu(){}

    public void salir() {
        System.out.println("Gracias vuelva prontos.");
    }

    public void noReconocida() {
                System.out.println("Opcion no reconocida.");
    }
    
}