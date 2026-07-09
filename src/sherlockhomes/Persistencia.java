package sherlockhomes;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    
    public static void guardarUsuarios(ArrayList<Usuario> usuarios, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Usuario> cargarUsuarios(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (Exception e) {
            ArrayList<Usuario> usuariosHard = new ArrayList<>();

            usuariosHard.add(new Socio("Gian", 11111111, "1151107777", "CABA", "gianSoc", "gian"));
            usuariosHard.add(new Empleado("Facu", 22222222, "1151108888", "CABA", "facuEmp", "facu", 2222, "ALGO"));
            usuariosHard.add(new Usuario("Heber", 33333333, "1151108888", "CABA", "heberAdmin", "heber", TipoUsuario.ADMINISTRADOR));
            
            return usuariosHard; // si falla, devuelve lista vacía
        }
    }
    
    public static void guardarVehiculos(ArrayList<Vehiculo> vehiculos, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(vehiculos);
            System.out.println("Vehiculos guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Vehiculo> cargarVehiculos(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (ArrayList<Vehiculo>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); // si falla, devuelve lista vacía
        }
    }
    
        public static void guardarGarages(ArrayList<Garage> garages, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(garages);
            System.out.println("Garages guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Garage> cargarGarages(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (ArrayList<Garage>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); // si falla, devuelve lista vacía
        }
    }
    
        public static void guardarZonas(ArrayList<Zona> zonas, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(zonas);
            System.out.println("Zonas guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Zona> cargarZonas(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (ArrayList<Zona>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); // si falla, devuelve lista vacía
        }
    }
}
