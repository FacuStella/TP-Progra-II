package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class EmpleadoUtils {
    public static Empleado buscarEmpleadoPorDni(ArrayList<Empleado> empleados, int dni) {
        for (Empleado e : empleados) {
            if (e.getDNI() == dni) {
                return e;
            }
        }
        return null;
    }
    
    public static Empleado buscarEmpleadoPorCodigo(ArrayList<Empleado> empleados, int codigo) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }
    
    public static void listarEmpleado(Empleado empleado) {
        System.out.println("Nombre: " + empleado.getNombre() +
                           " | DNI: " + empleado.getDNI() +
                           " | Teléfono: " + empleado.getTelefono() +
                           " | Dirección: " + empleado.getDireccion());
    }

    public static void listarEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("=== Lista de Empleados ===");
        for (Empleado e : empleados) {
            listarEmpleado(e);
        }
    }

    public static void eliminarEmpleado(ArrayList<Empleado> empleados, Empleado empleado) {
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado empleadoAux = it.next();
            if (empleadoAux.getCodigo() == empleado.getCodigo()) {
                it.remove(); 
            }
        }
    }
}
