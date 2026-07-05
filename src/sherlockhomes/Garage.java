package sherlockhomes;

import java.util.Date;

public class Garage {
    protected int numeroGarage;
    protected double lecturaContadorLuz;
    protected boolean mantenimientoContratado;
    protected Vehiculo vehiculoOcupante;
    protected Zona zona;
    
    protected Socio propietario;
    protected Date fechaCompra;
    
    public Garage(int numeroGarage, double lecturaContadorLuz, boolean mantenimientoContratado) {
        this.numeroGarage = numeroGarage;
        this.lecturaContadorLuz = lecturaContadorLuz;
        this.mantenimientoContratado = mantenimientoContratado;
    }
    
     public void asignarPropietario(Socio socio, Date fechaCompra) {
        this.propietario = socio;
        this.fechaCompra = fechaCompra;
    }

    public void removerPropietario() {
        this.propietario = null;
        this.fechaCompra = null;
    }

    public boolean tienePropietario() {
        return propietario != null;
    }
}