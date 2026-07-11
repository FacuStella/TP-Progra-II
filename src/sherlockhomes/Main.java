package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Sistema s = new Sistema(sc);
        
        do{
            s.iniciar();
        } while (1==1);
        
        //sc.close();
    }
    
}
