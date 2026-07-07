package sherlockhomes;

import java.io.*;
import java.util.ArrayList;

public class PersistenciaUsuarios {
    
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
            e.printStackTrace();
            return new ArrayList<>(); // si falla, devuelve lista vacía
        }
    }
}
