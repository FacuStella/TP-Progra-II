package sherlockhomes;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public Usuario ingresar(Scanner sc, ArrayList<Usuario> usuarios) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Usuario usuario;
        do{
            System.out.print("Usuario: ");
            String username = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            usuario = autenticar(usuarios, username, password);
            if(usuario == null){
                System.out.println("Credenciales inválidas.");
            }
        } while (usuario == null);
            
        return usuario;
    }

    protected Usuario autenticar(ArrayList<Usuario> usuarios,String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.validarPassword(password)) {
                return u;
            }
        }
        return null;
    }

}
