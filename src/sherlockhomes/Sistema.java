package sherlockhomes;

import acciones.AccionesSocio;
import acciones.AccionesEmpleado;
import acciones.*;
import vistas.socio.*;
import vistas.empleado.*;
import vistas.admin.*;
import vistas.*;
import java.util.ArrayList;
import java.util.Scanner;
import static sherlockhomes.TipoUsuario.ADMINISTRADOR;
import static sherlockhomes.TipoUsuario.EMPLEADO;
import static sherlockhomes.TipoUsuario.SOCIO;

public class Sistema {
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Empleado> empleados;
    protected ArrayList<Socio> socios;
    protected Usuario usuarioLogueado;
    protected Scanner sc;
    
    public Sistema (Scanner sc, ArrayList<Usuario> usuarios, ArrayList<Vehiculo> vehiculos, ArrayList<Garage> garages, ArrayList<Zona> zonas) {
        this.usuarios = usuarios;
        this.sc = sc;
        cargaListas(usuarios);
    }
    
    public void iniciar() {  
        cargaUsuario();
        
        int accion;
        do{
            accion = mostrarMenu(usuarioLogueado, sc);
            ejecutarAccion(usuarios, socios, empleados, usuarioLogueado, accion, sc);
        } while(accion != 0);
    }
    
    private void cargaListas(ArrayList<Usuario> usuarios) {
        socios = new ArrayList<>();

        for (Usuario u : usuarios) {
            if (u instanceof Socio) {
                socios.add((Socio) u); 
            }
        }
        
        empleados = new ArrayList<>();
        
        for (Empleado u : empleados) {
            if (u instanceof Empleado) {
                empleados.add((Empleado) u); 
            }
        }
    }

    protected int mostrarMenu(Usuario usuario, Scanner sc) {
        int aux = 0;
        switch (usuario.getTipoUsuario()) {
            case SOCIO -> {
                Vista menuSocio = new VistaSocio();
                aux = menuSocio.a(sc);
            }
            case EMPLEADO -> {
                Vista menuEmpleado = new VistaEmpleado();
                aux = menuEmpleado.a(sc);
            }
            case ADMINISTRADOR -> {
                Vista menuAdmin = new VistaAdministrador();
                aux = menuAdmin.a(sc);
            }
        }
        return aux;
    }
    
    protected void ejecutarAccion(ArrayList<Usuario> usuarios, ArrayList<Socio> socios, ArrayList<Empleado> empleados, Usuario usuarioLogueado, int accion, Scanner sc) {
        switch (usuarioLogueado.getTipoUsuario()) {
            case SOCIO -> {
                Socio socioAux = (Socio) usuarioLogueado;
                AccionesSocio accionesSocio = new AccionesSocio();
                accionesSocio.ejecutar(socioAux, accion);
            }
            case EMPLEADO -> {
                Empleado empleadoAux = (Empleado) usuarioLogueado;
                AccionesEmpleado accionesEmpleado = new AccionesEmpleado();
                accionesEmpleado.ejecutar(empleadoAux, accion);
            }
            case ADMINISTRADOR -> {
                int opcAdm;
                opcAdm = mostrarMenuAdmin(accion, sc);
                AccionesAdmin accionesAdmin = new AccionesAdmin();
                accionesAdmin.ejecutar(usuarios, socios, empleados, usuarioLogueado, opcAdm, sc);
            }
        }
    }
    
    protected int mostrarMenuAdmin(int opcion, Scanner sc) {
        int aux = 0;
        switch (opcion) {
            case 1 -> {
                Vista vistaGestionSocios = new VistaGestionSocios();
                aux = vistaGestionSocios.a(sc);  
            }
            case 2 -> {
                Vista vistaGestionVehiculos = new VistaGestionVehiculos();
                aux = vistaGestionVehiculos.a(sc);  
            }
            case 3 -> {
                Vista vistaGestionGarages = new VistaGestionGarages();
                aux = vistaGestionGarages.a(sc);  
            }
            case 4 -> {
                Vista vistaGestionZonas = new VistaGestionZonas();
                aux = vistaGestionZonas.a(sc);  
            }
            case 5 -> {
                Vista vistaGestionEmpleados = new VistaGestionEmpleados();
                aux = vistaGestionEmpleados.a(sc);  
            }
            case 0 -> {
                Vista vista = new Vista();
                vista.salir(); 
            }
            default -> {
                Vista vista = new Vista();
                vista.noReconocida();
            }
        }
        return aux;
    }

    private void cargaUsuario() {
        Login login = new Login();
        usuarioLogueado = login.ingresar(sc, usuarios);
    }

    

}
