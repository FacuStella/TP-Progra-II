package sherlockhomes;

import java.util.Scanner;

public class Menu {
    
    public int a(Scanner sc){
        String input;
        int opcion = -1;
        
        do{
            mostrarMenu();
            input = sc.nextLine();

            if (input.matches("\\d{1}")) {
                opcion = Integer.parseInt(input);
            }   
        } while(opcion == -1);
        acciones(opcion);
        return opcion == 0 ? 1 : 0 ;
    }
    
    protected void mostrarMenu(){}
    
    protected void acciones(int tipo) {}
}