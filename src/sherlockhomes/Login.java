package sherlockhomes;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import static sherlockhomes.Persistencia.cargarUsuarios;

public class Login {
    public Usuario ingresar(Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Usuario usuario;
        do{
            System.out.print("Usuario: ");
            String username = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            usuario = autenticar(username, password);
            if(usuario == null){
                System.out.println("Credenciales inválidas.");
            }
        } while (usuario == null);
            
        return usuario;
    }

    protected Usuario autenticar(String username, String password) {
        ArrayList<Usuario> usuarios = cargarUsuarios();
        
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.validarPassword(password)) {
                return u;
            }
        }
        
        return null;
    }

}
