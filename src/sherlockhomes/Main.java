package sherlockhomes;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        
        do{
            login.ingresar(sc);
        } while (1==1);
        
        //sc.close();
    }
    
}
