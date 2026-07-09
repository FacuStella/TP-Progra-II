package sherlockhomes;

import java.util.Date;

public class Vehiculo {

    protected String matricula;
    protected String marca;
    protected String tipo;
    protected String dimensiones;
    protected Socio propietario;
    
    private Garage garageAsignado;
    private Date fechaAsignacion;

    public Vehiculo(String matricula, String marca, String tipo, String dimensiones, Socio propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
        this.propietario = propietario;
    }

    public void asignarGarage(Garage garage, Date fecha) {
        this.garageAsignado = garage;
        this.fechaAsignacion = fecha;
    }

    public void removerGarage() {
        this.garageAsignado = null;
        this.fechaAsignacion = null;
    }

    public boolean tieneGarageAsignado() {
        return garageAsignado != null;
    }
    
}