package sherlockhomes;

import java.util.ArrayList;

public class Empleado extends Persona {

    protected int codigo;
    protected String especialidad;
    protected ArrayList<ZonaEmpleado> zonasAsignadas;

    public Empleado(String nombre, int DNI, String direccion, String telefono, int codigo, String especialidad) {
        super(nombre, DNI, direccion, telefono);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.zonasAsignadas = new ArrayList();
    }

    public int getCodigo() {
        return this.codigo; 
    }
    
    public String getEspecialidad() {
        return this.especialidad; 
    }
    
    public void asignarZona(Zona zona, ArrayList<Vehiculo> vehiculos) {
        zonasAsignadas.add(new ZonaEmpleado(zona.getLetra(), this.codigo, vehiculos));
    }

    public void removerZona(Zona zona) {
        zonasAsignadas.removeIf(asignacion -> asignacion.getZona().equals(zona.getLetra()));
    }

    public ArrayList<String> getZonasAsignadas() {
        ArrayList<String> letras = new ArrayList<>();
        for (ZonaEmpleado asignacion : zonasAsignadas) {
            if (asignacion.getCodigoEmpleado() == this.codigo) {
                letras.add(asignacion.getZona());
            }
        }
        return letras;
    }
   
}