package sherlockhomes;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L; 
    protected String nombre;
    protected int DNI;
    protected String direccion;
    protected String telefono;
    
    public Persona(String nombre, int DNI, String direccion, String telefono){
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Persona(){
    }
}