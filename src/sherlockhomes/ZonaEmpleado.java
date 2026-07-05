package sherlockhomes;

import java.util.ArrayList;

public class ZonaEmpleado {
    protected String letra;
    protected int codigoEmpleado;
    protected ArrayList<Vehiculo> vehiculos;  

    public ZonaEmpleado(String letra, int codigoEmpleado, ArrayList<Vehiculo> vehiculos) {
        this.letra = letra;
        this.codigoEmpleado = codigoEmpleado;
        this.vehiculos = vehiculos;
    }

    public String getZona() {
        return this.letra;
    }

    public int getCodigoEmpleado() {
        return this.codigoEmpleado;
    }
    
}