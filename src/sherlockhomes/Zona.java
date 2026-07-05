package sherlockhomes;

import java.util.ArrayList;

public class Zona {
    protected String letra;
    protected ArrayList<String> tipoVehiculos;
    protected int numeroVehiculos;
    protected int profundidadGarage;
    protected int anchoGarage;
    protected ArrayList<Garage> garages;
    protected ArrayList<Empleado> empleados;
    
    public void agregarGarage(Garage garage) {
        garages.add(garage);
    }

    public void asignarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public ArrayList<Garage> getGarages() {
        return garages;
    }

    public ArrayList<Empleado> getEmpleadosAsignados() {
        return empleados;
    }

    public String getLetra() {
        return this.letra;
    }
}