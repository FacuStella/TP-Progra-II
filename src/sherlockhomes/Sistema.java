package sherlockhomes;

import vistas.*;
import vistas.admin.*;
import acciones.*;
import static sherlockhomes.TipoUsuario.*;

public class Sistema {
    protected Usuario usuarioLogueado;
    protected static final Vista vista = new Vista();
   
    public Sistema () {
    }
    
    public void iniciar() { 
        logueaUsuario();
        catalogaUsuario();
        
        int accion;
        do{
            accion = mostrarMenu();
            ejecutarAccion(accion);
        } while(accion != 0);
    }
    
    protected void logueaUsuario() {
        Login login = new Login();
        usuarioLogueado = login.ingresar();
    }
    
    private void catalogaUsuario() {
        switch (usuarioLogueado.getTipoUsuario()) {
            case SOCIO -> {
                usuarioLogueado = (Socio) usuarioLogueado;
            }
            case EMPLEADO -> {
                usuarioLogueado = (Empleado) usuarioLogueado;
            }
        }
    }
    
    protected int mostrarMenu() {
        int opcion = 0;
        do{
            switch (usuarioLogueado) {
                case Empleado e -> vista.mostrarMenu(e);
                case Socio s -> vista.mostrarMenu(s);
                default -> vista.mostrarMenu(usuarioLogueado);
            }
            opcion = EntradaCons.ingresaInt();
        } while (opcion == -1);
        return opcion;
    }
    
    protected void ejecutarAccion(int opcion) {
        int opcAdm = 0;
        if (usuarioLogueado.getTipoUsuario() == ADMINISTRADOR){
            opcAdm = mostrarMenuAdmin(opcion);
        }
        Acciones acciones = new Acciones();
        switch (usuarioLogueado) {
            case Empleado e -> acciones.ejecutar(e, opcion, opcAdm);
            case Socio s -> acciones.ejecutar(s, opcion, opcAdm);
            default -> acciones.ejecutar(usuarioLogueado, opcion, opcAdm);
        }
                  
    }
    
    protected int mostrarMenuAdmin(int opcion) {
        int opcionAdmin = 0;
        VistaGestion vistaGestion = null;
        switch (opcion) {
            case 1 -> vistaGestion = new VistaGestionSocios(); 
            case 2 -> vistaGestion = new VistaGestionVehiculos();
            case 3 -> vistaGestion = new VistaGestionGarages();
            case 4 -> vistaGestion = new VistaGestionZonas();
            case 5 -> vistaGestion = new VistaGestionEmpleados();
            case 0 -> vista.salir(); 
            default -> vista.noReconocida(); 
        }
        if(vistaGestion != null){
            do{
                vistaGestion.mostrarMenu();
                opcionAdmin = EntradaCons.ingresaInt();
            } while (opcionAdmin == -1);
        }
        return opcionAdmin;
    }

 

}
