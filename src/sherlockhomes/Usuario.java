package sherlockhomes;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable {
    private static final long serialVersionUID = 1L; 
    private static int contadorId = 0; 
    protected int ID;
    protected String username;
    protected String password;
    protected TipoUsuario tipoUsuario;

    public Usuario(String nombre, int DNI, String direccion, String telefono, String username, String password, TipoUsuario tipoUsuario) {
        super(nombre, DNI, direccion, telefono);
        this.ID = contadorId++;
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    public String toCSV() {
        return ID + "," + username + "," + password + "," + tipoUsuario;
    }

}
