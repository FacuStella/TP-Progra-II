package sherlockhomes;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioUtils {
    public static Usuario buscarUsuarioPorDni(ArrayList<Usuario> usuarios, int dni) {
        for (Usuario u : usuarios) {
            if (u.getDNI() == dni) {
                return u;
            }
        }
        return null;
    }
    
    public static void listarUsuario(Usuario usuario) {
        System.out.println("Id: " + usuario.getId() +
                            " | Usuario: " + usuario.getUserName() +
                            " | Tipo usuario: " + usuario.getTipoUsuario());
    }

    public static void listarUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("=== Lista de Usuarios ===");
        for (Usuario u : usuarios) {
            listarUsuario(u);
        }
    }

    public static void eliminarUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario usuarioAux = it.next();
            if (usuarioAux.getDNI() == usuario.getDNI()) {
                it.remove(); 
            }
        }
    }
}
