package acciones;

import sherlockhomes.Usuario;

public class AccionesAdmin {

    public void ejecutar(Usuario usuarioLogueado, int opc, int opcAdm) {
        AccionesAdmin accionesAdmin = null;
        switch (opc) {
            case 1 -> accionesAdmin = new AccionesAdminSocio();
            case 2 -> accionesAdmin = new AccionesAdminVehiculo();
            case 3 -> accionesAdmin = new AccionesAdminGarage();
            case 4 -> accionesAdmin = new AccionesAdminZona();
            case 5 -> accionesAdmin = new AccionesAdminEmpleado();  
            case 0 -> {}
            default -> {}
        }
        if (accionesAdmin != null){
            accionesAdmin.ejecutar(usuarioLogueado, opcAdm);
        }
    }
    
    public void ejecutar(Usuario usuarioLogueado, int opc){}
}
