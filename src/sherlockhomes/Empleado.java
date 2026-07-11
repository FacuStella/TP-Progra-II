package sherlockhomes;

import java.io.Serializable;
import java.util.ArrayList;
import static sherlockhomes.TipoUsuario.EMPLEADO;

public class Empleado extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L; 
    
    private static int contadorCodigo = 1000; 
    protected int codigo;
    protected String especialidad;
    protected ArrayList<Zona> zonasAsignadas;
    protected ArrayList<Vehiculo> vehiculosAsignados;

    public Empleado(String nombre, int DNI, String direccion, String telefono, String especialidad) {
        super(nombre, DNI, direccion, telefono, nombre+"Emp",String.format("%04d", DNI % 10000), EMPLEADO);
        this.codigo = contadorCodigo++;
        this.especialidad = especialidad;
        this.zonasAsignadas = new ArrayList();
    }

    public int getCodigo() {
        return codigo; 
    }
    
    public String getEspecialidad() {
        return especialidad; 
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public ArrayList<Zona> getZonasAsignadas() {
        return zonasAsignadas; 
    }
    
    public void asignarZona(Zona zona) {
        zonasAsignadas.add(zona);
    }
    
    public ArrayList<Vehiculo> getVehiculosAsignados() {
        return vehiculosAsignados; 
    }
    
    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculosAsignados.add(vehiculo);
    }
    
}