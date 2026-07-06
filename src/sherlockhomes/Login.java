package sherlockhomes;

import java.util.Scanner;

public class Login {
    private static Usuario[] usuarios = {
        new Usuario("socio1", "1234", TipoUsuario.SOCIO),
        new Usuario("empleado1", "abcd", TipoUsuario.EMPLEADO),
        new Usuario("admin1", "admin", TipoUsuario.ADMINISTRADOR)
    };

    public void ingresar(Scanner sc) {
        int sale = 0;
        System.out.print("Usuario: ");
        String username = sc.nextLine();

        System.out.print("Contraseña: ");
        String password = sc.nextLine();

        Usuario usuario = autenticar(username, password);

        if (usuario != null) {
            do{
                sale = mostrarMenu(usuario, sc);
            } while(sale == 0);
        } else {
            System.out.println("Credenciales inválidas.");
        }
    }

    protected Usuario autenticar(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.validarPassword(password)) {
                return u;
            }
        }
        return null;
    }

    protected int mostrarMenu(Usuario usuario, Scanner sc) {
        int aux = 0;
        switch (usuario.getTipoUsuario()) {
            case SOCIO -> {
                Menu menuSocio = new MenuSocio();
                aux = menuSocio.a(sc);
            }
            case EMPLEADO -> {
                Menu menuEmpleado = new MenuEmpleado();
                aux = menuEmpleado.a(sc);
            }
            case ADMINISTRADOR -> {
                Menu menuAdmin = new MenuAdministrador();
                aux = menuAdmin.a(sc);
            }
        }
        return aux;
    }

}
