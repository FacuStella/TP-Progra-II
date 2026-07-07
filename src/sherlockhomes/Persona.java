package sherlockhomes;

public abstract class Persona {
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