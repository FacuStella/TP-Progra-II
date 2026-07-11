package sherlockhomes;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    
    public static void guardarUsuarios(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Usuario> cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (Exception e) {
            ArrayList<Usuario> usuariosHard = new ArrayList<>();

            //usuariosHard.add(new Socio("Gian", 11111111, "1151107777", "CABA", "gianSoc", "gian"));
            //usuariosHard.add(new Empleado("Facu", 22222222, "1151108888", "CABA", "facuEmp", "facu", "ALGO"));
            usuariosHard.add(new Usuario("admin", 11111111, "1122223333", "CABA", "admin", "admin", TipoUsuario.ADMINISTRADOR));
            
            return usuariosHard; 
        }
    }
    
    public static ArrayList<Socio> cargarSocios() {
        ArrayList<Socio> socios = new ArrayList<>();
        
        for (Usuario u : cargarUsuarios()) {
            if (u instanceof Socio) {
                    socios.add((Socio) u); 
                }
        }
            
        return socios;
    }
        
    public static ArrayList<Empleado> cargarEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        for (Usuario u : cargarUsuarios()) {
            if (u instanceof Empleado) {
                    empleados.add((Empleado) u); 
                }
        }
            
        return empleados;
    }
    
    public static void guardarVehiculos(ArrayList<Vehiculo> vehiculos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vehiculos.dat"))) {
            oos.writeObject(vehiculos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Vehiculo> cargarVehiculos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vehiculos.dat"))) {
            return (ArrayList<Vehiculo>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }
    
        public static void guardarGarages(ArrayList<Garage> garages) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("garages.dat"))) {
            oos.writeObject(garages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Garage> cargarGarages() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("garages.dat"))) {
            return (ArrayList<Garage>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }
    
        public static void guardarZonas(ArrayList<Zona> zonas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zonas.dat"))) {
            oos.writeObject(zonas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Zona> cargarZonas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("zonas.dat"))) {
            return (ArrayList<Zona>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }
}
