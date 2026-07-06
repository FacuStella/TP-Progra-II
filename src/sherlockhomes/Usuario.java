package sherlockhomes;

public class Usuario {
    private static int contadorId = 0; 
    protected int ID;
    protected String username;
    protected String password;
    protected TipoUsuario tipoUsuario;

    public Usuario(String username, String password, TipoUsuario tipoUsuario) {
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
}
