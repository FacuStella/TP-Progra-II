package sherlockhomes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
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
