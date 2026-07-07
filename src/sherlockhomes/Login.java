package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void ingresar(Scanner sc, ArrayList<Usuario> usuarios) {

        int sigue;
        System.out.print("Usuario: ");
        String username = sc.nextLine();

        System.out.print("Contraseña: ");
        String password = sc.nextLine();

        Usuario usuario = autenticar(usuarios, username, password);

        if (usuario != null) {
            do{
                sigue = mostrarMenu(usuarios, usuario, sc);
            } while(sigue != 0);
        } else {
            System.out.println("Credenciales inválidas.");
        }
    }

    protected Usuario autenticar(ArrayList<Usuario> usuarios,String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.validarPassword(password)) {
                return u;
            }
        }
        return null;
    }

    protected int mostrarMenu(ArrayList<Usuario> usuarios, Usuario usuario, Scanner sc) {
        int aux = 0;
        switch (usuario.getTipoUsuario()) {
            case SOCIO -> {
                Menu menuSocio = new MenuSocio();
                Socio socioAux = (Socio) usuario;
                aux = menuSocio.a(sc);
                AccionesSocio accionesSocio = new AccionesSocio();
                accionesSocio.ejecutar(socioAux, aux);
            }
            case EMPLEADO -> {
                Menu menuEmpleado = new MenuEmpleado();
                Empleado empleadoAux = (Empleado) usuario;
                aux = menuEmpleado.a(sc);
                AccionesEmpleado accionesEmpleado = new AccionesEmpleado();
                accionesEmpleado.ejecutar(empleadoAux, aux);
            }
            case ADMINISTRADOR -> {
                Menu menuAdmin = new MenuAdministrador();
                // Empleado empleadoAux = (Empleado) usuario;
                aux = menuAdmin.a(sc);
                AccionesAdmin accionesAdmin = new AccionesAdmin();
                accionesAdmin.ejecutar(usuarios, usuario, aux, sc);
            }
        }
        return aux;
    }

    private void accionesSocio(Socio socioAux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
