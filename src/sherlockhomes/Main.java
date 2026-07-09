package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //ArrayList<Usuario> usuariosHard = new ArrayList<>();

        //usuariosHard.add(new Socio("Gian", 11111111, "1151107777", "CABA", "gianSoc", "gian"));
        //usuariosHard.add(new Empleado("Facu", 22222222, "1151108888", "CABA", "facuEmp", "facu", 2222, "ALGO"));
        //usuariosHard.add(new Usuario("Heber", 33333333, "1151108888", "CABA", "heberAdmin", "heber", TipoUsuario.ADMINISTRADOR));
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios("usuarios.dat");
        ArrayList<Vehiculo> vehiculos = Persistencia.cargarVehiculos("vehiculos.dat");
        ArrayList<Garage> garages = Persistencia.cargarGarages("garages.dat");
        ArrayList<Zona> zonas = Persistencia.cargarZonas("zonas.dat");
        
        Sistema s = new Sistema(sc, usuarios, vehiculos, garages, zonas);
        
        do{
            s.iniciar();
            Persistencia.guardarUsuarios(usuarios, "usuarios.dat");
            Persistencia.guardarVehiculos(vehiculos, "vehiculos.dat");
            Persistencia.guardarGarages(garages, "garages.dat");
            Persistencia.guardarZonas(zonas, "zonas.dat");
        } while (1==1);
        
        //sc.close();
    }
    
}
