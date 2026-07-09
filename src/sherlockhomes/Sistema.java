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
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Empleado> empleados;
    protected ArrayList<Socio> socios;
    protected ArrayList<Vehiculo> vehiculos;
    protected ArrayList<Garage> garages;
    protected ArrayList<Zona> zonas;
    protected Usuario usuarioLogueado;
    protected Scanner sc;
    
    public Sistema (Scanner sc, ArrayList<Usuario> usuarios, ArrayList<Vehiculo> vehiculos, ArrayList<Garage> garages, ArrayList<Zona> zonas) {
        this.usuarios = usuarios;
        cargaListas(usuarios);
        this.vehiculos = vehiculos;
        this.garages = garages;
        this.zonas = zonas;
        this.sc = sc;
    }
    
    protected void cargaListas(ArrayList<Usuario> usuarios) {
        socios = new ArrayList<>();

        for (Usuario u : usuarios) {
            if (u instanceof Socio) {
                System.out.println("Encontro un socio");
                socios.add((Socio) u); 
            }
        }
        
        empleados = new ArrayList<>();
        
        for (Usuario u : usuarios) {
            if (u instanceof Empleado) {
                System.out.println("Encontro un empleado");
                empleados.add((Empleado) u); 
            }
        }
    }
    
    public void iniciar() {  
        cargaUsuario();
        
        int accion;
        do{
            accion = mostrarMenu();
            ejecutarAccion(accion);
        } while(accion != 0);
    }
    
    protected void cargaUsuario() {
        Login login = new Login();
        usuarioLogueado = login.ingresar(sc, usuarios);
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
                opcAdm = mostrarMenuAdmin(opcion);
                AccionesAdmin accionesAdmin = new AccionesAdmin();
                accionesAdmin.ejecutar(usuarios, socios, empleados, vehiculos, garages, zonas, usuarioLogueado, opcion, opcAdm, sc);
            }
        }
    }
    
    protected int mostrarMenuAdmin(int opcion) {
        int opcionAdmin = 0;
        switch (opcion) {
            case 1 -> {
                Vista vistaGestionSocios = new VistaGestionSocios(); 
                do{
                    vistaGestionSocios.mostrarMenu();
                    opcionAdmin = vistaGestionSocios.ingresaInt(sc);
                } while (opcionAdmin == -1);
            }
            case 2 -> {
                Vista vistaGestionVehiculos = new VistaGestionVehiculos();
                do{
                    vistaGestionVehiculos.mostrarMenu();
                    opcionAdmin = vistaGestionVehiculos.ingresaInt(sc);
                } while (opcionAdmin == -1);
            }
            case 3 -> {
                Vista vistaGestionGarages = new VistaGestionGarages();
                do{
                    vistaGestionGarages.mostrarMenu();
                    opcionAdmin = vistaGestionGarages.ingresaInt(sc);
                } while (opcionAdmin == -1);  
            }
            case 4 -> {
                Vista vistaGestionZonas = new VistaGestionZonas();
                do{
                    vistaGestionZonas.mostrarMenu();
                    opcionAdmin = vistaGestionZonas.ingresaInt(sc);
                } while (opcionAdmin == -1);    
            }
            case 5 -> {
                Vista vistaGestionEmpleados = new VistaGestionEmpleados();
                do{
                    vistaGestionEmpleados.mostrarMenu();
                    opcionAdmin = vistaGestionEmpleados.ingresaInt(sc);
                } while (opcionAdmin == -1);  
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
        return opcionAdmin;
    }

}
