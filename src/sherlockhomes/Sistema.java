package sherlockhomes;

import models.Usuario;
import models.Empleado;
import models.Socio;
import controllers.ControllerAdmin;
import controllers.ControllerSocio;
import controllers.ControllerEmpleado;
import static sherlockhomes.TipoUsuario.*;

public class Sistema {
    protected Usuario usuarioLogueado;
    protected ControllerEmpleado controllerEmpleado;
    protected ControllerSocio controllerSocio;
    protected ControllerAdmin controllerAdmin;
   
    public Sistema () {
        controllerEmpleado = new ControllerEmpleado();
        controllerSocio = new ControllerSocio();
        controllerAdmin = new ControllerAdmin();
    }
    
    public void iniciar() { 
        logueaUsuario();
        if(!(usuarioLogueado == null)){
            switch (usuarioLogueado.getTipoUsuario()) {
                case EMPLEADO -> controllerEmpleado.iniciar((Empleado) usuarioLogueado);
                case SOCIO -> controllerSocio.iniciar((Socio) usuarioLogueado);
                case ADMINISTRADOR -> controllerAdmin.iniciar(usuarioLogueado);
            }
        }
    }
    
    protected void logueaUsuario() {
        Login login = new Login();
        usuarioLogueado = login.ingresar();
    }   
}
