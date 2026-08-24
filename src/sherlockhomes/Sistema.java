package sherlockhomes;

import vistas.*;
import vistas.socio.*;
import vistas.empleado.*;
import vistas.admin.*;
import acciones.*;
import java.util.ArrayList;
import java.util.Scanner;
import static sherlockhomes.TipoUsuario.*;

public class Sistema {
    protected Usuario usuarioLogueado;
    protected Scanner sc;
   
    public Sistema (Scanner sc) {
        this.sc = sc;
    }
    
    public void iniciar() {  
        logueaUsuario();
        
        int accion;
        do{
            accion = mostrarMenu();
            ejecutarAccion(accion);
        } while(accion != 0);
    }
    
    protected void logueaUsuario() {
        Login login = new Login();
        usuarioLogueado = login.ingresar(sc);
    }
    
    protected int mostrarMenu() {
        int opcion = 0;
        switch (usuarioLogueado.getTipoUsuario()) {
            case SOCIO -> {
                Vista vistaSocio = new VistaSocio();
                do{
                    vistaSocio.mostrarMenu();
                    opcion = vistaSocio.ingresaInt(sc);
                } while (opcion == -1);
            }
            case EMPLEADO -> {
                Vista vistaEmpleado = new VistaEmpleado();
                do{
                    vistaEmpleado.mostrarMenu();
                    opcion = vistaEmpleado.ingresaInt(sc);
                } while (opcion == -1);
            }
            case ADMINISTRADOR -> {
                Vista vistaAdmin = new VistaAdministrador();
                do{
                    vistaAdmin.mostrarMenu();
                    opcion = vistaAdmin.ingresaInt(sc);
                } while (opcion == -1);
            }
        }
        return opcion;
    }
    
    protected void ejecutarAccion(int opcion) {
        switch (usuarioLogueado.getTipoUsuario()) {
            case SOCIO -> {
                Socio socioAux = (Socio) usuarioLogueado;
                AccionesSocio accionesSocio = new AccionesSocio();
                accionesSocio.ejecutar(socioAux, opcion);
            }
            case EMPLEADO -> {
                Empleado empleadoAux = (Empleado) usuarioLogueado;
                AccionesEmpleado accionesEmpleado = new AccionesEmpleado();
                accionesEmpleado.ejecutar(empleadoAux, opcion);
            }
            case ADMINISTRADOR -> {
                int opcAdm;
                do{
                    opcAdm = mostrarMenuAdmin(opcion);
                    AccionesAdmin accionesAdmin = new AccionesAdmin();
                    accionesAdmin.ejecutar(usuarioLogueado, opcion, opcAdm, sc);
                } while(opcAdm != 0);
            }
        }
    }
    
    protected int mostrarMenuAdmin(int opcion) {
        int opcionAdmin = 0;
        Vista vistaGestion;
        switch (opcion) {
            case 1 -> vistaGestion = new VistaGestionSocios(); 
            case 2 -> vistaGestion = new VistaGestionVehiculos();
            case 3 -> vistaGestion = new VistaGestionGarages();
            case 4 -> vistaGestion= new VistaGestionZonas();
            case 5 -> vistaGestion = new VistaGestionEmpleados();
            case 0 -> {
                vistaGestion = new Vista();
                vistaGestion.salir(); 
            }
            default -> {
                vistaGestion = new Vista();
                vistaGestion.noReconocida(); 
            }
        }
        if(opcion > 0 && opcion <= 5){
            do{
                vistaGestion.mostrarMenu();
                opcionAdmin = vistaGestion.ingresaInt(sc);
            } while (opcionAdmin == -1);
        }
        return opcionAdmin;
    }

}
