package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuariosHard = new ArrayList<>();

        usuariosHard.add(new Socio("Gian", 11111111, "1151107777", "CABA", "gianSoc", "gian"));
        usuariosHard.add(new Empleado("Facu", 22222222, "1151108888", "CABA", "facuEmp", "facu", 2222, "ALGO"));
        usuariosHard.add(new Usuario("Heber", 33333333, "1151108888", "CABA", "heberAdmin", "heber", TipoUsuario.ADMINISTRADOR));
        
        // Guardar en archivo
        PersistenciaUsuarios.guardarUsuarios(usuariosHard, "usuarios.dat");

        // Cargar desde archivo
        ArrayList<Usuario> usuarios = PersistenciaUsuarios.cargarUsuarios("usuarios.dat");
        
        do{
            s.iniciar(sc, usuarios);
        } while (1==1);
        
        //sc.close();
    }
    
}
