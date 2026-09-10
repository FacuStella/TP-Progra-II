package com.sherlockhomes.acciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import com.sherlockhomes.model.Empleado;
import com.sherlockhomes.model.EmpleadoRepositoryFile;
import com.sherlockhomes.model.Usuario;
import com.sherlockhomes.model.VehiculoRepositoryFile;
import com.sherlockhomes.model.ZonaRepositoryFile;

public class AccionesAdminEmpleado {
    
    protected EmpleadoRepositoryFile employeeRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    protected ZonaRepositoryFile zoneRepository;
    
    public AccionesAdminEmpleado(){
        employeeRepository = new EmpleadoRepositoryFile();
        vehicleRepository = new VehiculoRepositoryFile();
        zoneRepository = new ZonaRepositoryFile();
    }

    public void ejecutar(Usuario usuarioLogueado, int opc, Scanner sc) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        switch (opc) {
            case 1 -> registrarEmpleado(sc);
            case 2 -> modificarEmpleado(sc);
            case 3 -> eliminarEmpleado(sc);
            case 4 -> asignarEmpleadoZona(sc);
            case 5 -> quitarEmpleadoZona(sc);
            case 6 -> listarEmpleadoZonas(sc);
            case 7 -> asignarVehiculoEmpleado(sc);
            case 8 -> quitarEmpleadoVehiculo(sc);
            case 9 -> listarEmpleadoVehiculos(sc);
            case 10 -> employeeRepository.listarAll();
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }

    public int menuBusquedaEmpleado(Scanner sc) {
        System.out.println("Ingrese clave por la que desea buscar al empleado.");
        System.out.println("1. Por DNI");
        System.out.println("2. Por codigo");
        int opcion = sc.nextInt();
        sc.nextLine();
            
        return opcion;
    }

    private void registrarEmpleado(Scanner sc) {
        System.out.println("=== Registro de nuevo Empleado ===");

        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese DNI: ");
        int DNI = sc.nextInt();
        sc.nextLine();

        if(employeeRepository.existePorValor(DNI,1)){
            System.out.println("Ya existe empleado con DNI " + DNI + ".");
            return;
        }

        System.out.print("Ingrese direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Ingrese Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Ingrese Especialidad: ");
        String especialidad = sc.nextLine();
        
        try{
            Empleado aux = new Empleado(nombre, DNI, direccion, telefono, especialidad);
            employeeRepository.crear(aux);
            System.out.println("Se agregó el empleado exitosamente.");
            employeeRepository.mostrarPorValor(DNI,1);
        } catch(Exception e) {
            System.out.println("Fallo registro de empleado." + e.getMessage());
        }
    }

    private void modificarEmpleado(Scanner sc) {
        System.out.println("=== Modificar Empleado ===");
                
        int buscarPor = menuBusquedaEmpleado(sc);
        int aux;
        switch(buscarPor){
            case 1 -> System.out.println("Ingrese DNI: ");
            case 2 -> System.out.println("Ingrese codigo: ");
            default -> {return;}
        }
        aux = sc.nextInt();
        sc.nextLine();
        if(!employeeRepository.existePorValor(aux,buscarPor)){
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Modificar direccion o vacio: ");
        String direccion = sc.nextLine();

        System.out.print("Modificar telefono o vacio: ");
        String telefono = sc.nextLine();

        System.out.print("Modificar especialidad o vacio: ");
        String especialidad = sc.nextLine();
        
        Empleado empleado = new Empleado("", 0, direccion, telefono, especialidad);
        employeeRepository.modificarPorValor(aux, buscarPor, empleado);
        System.out.println("Se modificó existosamente el empleado.");
        employeeRepository.mostrarPorValor(aux,buscarPor);
    }

    private void eliminarEmpleado(Scanner sc) {
        System.out.println("=== Eliminar Empleado ===");
        int buscarPor = menuBusquedaEmpleado(sc);
        int aux;
        switch(buscarPor){
            case 1 -> System.out.println("Ingrese DNI: ");
            case 2 -> System.out.println("Ingrese codigo: ");
            default -> {return;}
        }
        aux = sc.nextInt();
        sc.nextLine();
        if(employeeRepository.existePorValor(aux, buscarPor)){
            employeeRepository.eliminarPorValor(aux, buscarPor);
        } else {
            System.out.println("No existe el empleado ingresado.");
        }
        System.out.println("Se eliminó el empleado exitosamente.");
    }

    private void asignarEmpleadoZona(Scanner sc) {
        System.out.println("=== Asignar zona a empleado ===");
                
        System.out.print("Ingrese letra de la zona que quiere asignar: ");
        String letra = sc.nextLine();

        if(!zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        System.out.println("Ingrese codigo de empleado a asignar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        zoneRepository.asignarZonaEmpleado(letra, codigo);
        employeeRepository.asignarEmpleadoZona(codigo, zoneRepository.buscarZonaPorLetra(letra));
        
        System.out.println("Empleado asignado exitosamente.");
    }

    private void asignarVehiculoEmpleado(Scanner sc) {
        System.out.println("=== Asignar vehículo a empleado ===");
        
        employeeRepository.listarAll();
        
        System.out.println("Ingrese codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        vehicleRepository.listarVehiculosAll();
        
        System.out.println("Ingrese patente: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("El vehiculo no existe.");
            return;
        }
        
        if(vehicleRepository.tieneEmpleadoAsignado(patente)){
            vehicleRepository.quitarVehiculoEmpleado(patente);
        }
        
        vehicleRepository.asignarVehiculoEmpleado(patente,employeeRepository.buscarPorValor(codigo,2));
        employeeRepository.asignarEmpleadoVehiculo(codigo,vehicleRepository.buscarVehiculoPorPatente(patente));
        // falta modificar el objeto VehiculoAsignado de Garage
    }

    private void listarEmpleadoVehiculos(Scanner sc) {
        int buscarPor = menuBusquedaEmpleado(sc);
        int aux;
        switch(buscarPor){
            case 1 -> System.out.println("Ingrese DNI: ");
            case 2 -> System.out.println("Ingrese codigo: ");
            default -> {return;}
        }
        aux = sc.nextInt();
        sc.nextLine();
        if(employeeRepository.existePorValor(aux,buscarPor)){
            employeeRepository.listarEmpleadoVehiculos(employeeRepository.buscarPorValor(aux,buscarPor));
        } else {
            System.out.println("No existe el empleado ingresado.");
        }
    }
    
    private void listarEmpleadoZonas(Scanner sc) {
        int buscarPor = menuBusquedaEmpleado(sc);
        int aux;
        switch(buscarPor){
            case 1 -> System.out.println("Ingrese DNI: ");
            case 2 -> System.out.println("Ingrese codigo: ");
            default -> {return;}
        }
        aux = sc.nextInt();
        sc.nextLine();
        if(employeeRepository.existePorValor(aux,buscarPor)){
            employeeRepository.listarEmpleadoZonas(employeeRepository.buscarPorValor(aux,buscarPor));
        } else {
            System.out.println("No existe el empleado ingresado.");
        }
    }

    private void quitarEmpleadoZona(Scanner sc) {
        System.out.println("=== Quitar de zona a empleado ===");
        
        System.out.println("Ingrese codigo de empleado: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.listarEmpleadoZonas(employeeRepository.buscarPorValor(codigo,2));
                
        System.out.print("Ingrese letra de la zona que quiere quitar: ");
        String letra = sc.nextLine();

        if(!zoneRepository.existeZonaPorLetra(letra)){
            System.out.println("No existe la zona con letra " + letra + ".");
            return;
        }
        
        zoneRepository.quitarZonaEmpleado(letra, employeeRepository.buscarPorValor(codigo,2));
        employeeRepository.quitarEmpleadoZona(codigo, zoneRepository.buscarZonaPorLetra(letra));
        
        System.out.println("Empleado desasignado exitosamente.");
    }

    private void quitarEmpleadoVehiculo(Scanner sc) {
        System.out.println("=== Quitar vehiculo a empleado ===");
        
        System.out.println("Ingrese codigo de empleado: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(!employeeRepository.existePorValor(codigo,2)){
            System.out.println("El empleado no existe.");
            return;
        }
        
        employeeRepository.listarEmpleadoVehiculos(employeeRepository.buscarPorValor(codigo,2));
                
        System.out.print("Ingrese patente a quitar: ");
        String patente = sc.nextLine();

        if(!vehicleRepository.existeVehiculoPorPatente(patente)){
            System.out.println("No existe vehiculo.");
            return;
        }
        
        vehicleRepository.quitarVehiculoEmpleado(patente);
        employeeRepository.quitarEmpleadoVehiculo(codigo, vehicleRepository.buscarVehiculoPorPatente(patente));
        
        System.out.println("Vehiculo desasignado exitosamente.");
    }
     
}
