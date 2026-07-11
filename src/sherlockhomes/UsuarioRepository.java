package sherlockhomes;

import java.util.ArrayList;

public interface UsuarioRepository {
    //void crearUsuario(String nombre, int dni, String direccion, String telefono, String especialidad);
    //public Usuario buscarUsuarioPorDni(int DNI);
    //public Usuario buscarUsuarioPorCodigo(int codigo);
    public void agregarUsuario(Usuario usuario);
    public void mostrarUsuario(Usuario usuario);
    public void listarUsuariosAll();
    public void listarUsuarios(ArrayList<Usuario> usuarios);
    public void eliminarUsuario(Usuario usuario);
    //public boolean eliminarUsuarioPorDni(int DNI);
    //public boolean eliminarUsuarioPorCodigo(int codigo);
}
