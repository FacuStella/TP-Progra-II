package acciones;

import sherlockhomes.Empleado;
import sherlockhomes.Socio;
import sherlockhomes.Usuario;

public class Acciones {

    public Acciones() {
    }
        
    public void ejecutar(Empleado empleadoAux, int opc, int opcAdm) {
        AccionesEmpleado accionesEmpleado = new AccionesEmpleado();
        
        accionesEmpleado.ejecutar(empleadoAux, opc);
    }  
    
    public void ejecutar(Socio socioAux, int opc, int opcAdm) {
        AccionesSocio accionesSocio = new AccionesSocio();
        
        accionesSocio.ejecutar(socioAux, opc);
    }  
    
    public void ejecutar(Usuario usuarioAux, int opc, int opcAdm) {
        AccionesAdmin accionesAdmin = new AccionesAdmin();
        
        accionesAdmin.ejecutar(usuarioAux, opc, opcAdm);
    }  
}