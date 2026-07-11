package sherlockhomes;

import java.util.ArrayList;
import static sherlockhomes.Persistencia.cargarEmpleados;

public class EmpleadoRepositoryFile implements EmpleadoRepository{
    
    protected ArrayList<Empleado> empleados;
    protected UsuarioRepositoryFile userRepository;
    protected ZonaRepositoryFile zoneRepository;
    protected VehiculoRepositoryFile vehicleRepository;
    
    public EmpleadoRepositoryFile(){
        userRepository = new UsuarioRepositoryFile();
    }
    
    @Override
    public boolean crearEmpleado(String nombre, int DNI, String direccion, String telefono, String especialidad){ 
        if(existeEmpleadoPorDni(DNI)){
            System.out.println("Ya existe el empleado DNI " + DNI + ".");
            return false;
        } else {
                Empleado empleado = new Empleado(nombre, DNI, direccion, telefono, especialidad);

                userRepository.agregarUsuario(empleado);
                
                return true;
        }
    }
    
    @Override
    public Empleado buscarEmpleadoPorDni(int dni) {
        empleados = cargarEmpleados();
        
        for (Empleado e : empleados) {
            if (e.getDNI() == dni) {
                return e;
            }
        }
        return null;
    }
    
    @Override
    public Empleado buscarEmpleadoPorCodigo(int codigo) {
        empleados = cargarEmpleados();
        
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }
    
    @Override
    public boolean existeEmpleadoPorDni(int DNI){
        return buscarEmpleadoPorDni(DNI) == null ? false : true;
    }
    
    @Override
    public boolean existeEmpleadoPorCodigo(int codigo){
        return buscarEmpleadoPorCodigo(codigo) == null ? false : true;
    }
    
    @Override
    public boolean modificarEmpleadoPorDni(int DNI, String direccion, String telefono, String especialidad){
        empleados = cargarEmpleados();
        
        Empleado empleadoAux;
        
        empleadoAux = buscarEmpleadoPorDni(DNI);
        
        if(!direccion.isBlank()){empleadoAux.setDireccion(direccion);}
        if(!direccion.isBlank()){empleadoAux.setTelefono(telefono);}
        if(!especialidad.isBlank()){empleadoAux.setEspecialidad(especialidad);}
          
        userRepository.modificarEmpleado(empleadoAux);
        
        return true;
    }
    
    @Override
    public boolean modificarEmpleadoPorCodigo(int codigo, String direccion, String telefono, String especialidad){
        return buscarEmpleadoPorCodigo(codigo) == null ? false : true;
    }
    
    @Override
    public void mostrarEmpleado(Empleado empleado) {
        System.out.println("Nombre: " + empleado.getNombre() +
                           " | DNI: " + empleado.getDNI() +
                           " | Teléfono: " + empleado.getTelefono() +
                           " | Dirección: " + empleado.getDireccion());
    }
    
    @Override
    public void mostrarEmpleadoPorDni(int DNI){
        mostrarEmpleado(buscarEmpleadoPorDni(DNI));
    }
    
    @Override
    public void mostrarEmpleadoPorCodigo(int codigo){
        mostrarEmpleado(buscarEmpleadoPorCodigo(codigo));
    }
    
    @Override
    public void listarEmpleadosAll() {
        empleados = cargarEmpleados();
        System.out.println("=== Lista de Empleados ===");
        for (Empleado e : empleados) {
            mostrarEmpleado(e);
        }
    }

    @Override
    public void listarEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("=== Lista de Empleados ===");
        for (Empleado e : empleados) {
            mostrarEmpleado(e);
        }
    }
    
    @Override
    public void listarEmpleadoVehiculos(Empleado empleado) {
        vehicleRepository = new VehiculoRepositoryFile();
        System.out.println("=== Lista de vehiculos asignados del empleado "+empleado.getNombre()+" ===");
        vehicleRepository.listarVehiculos(empleado.getVehiculosAsignados());
    }

    @Override
    public void listarEmpleadoZonas(Empleado empleado) {
        zoneRepository = new ZonaRepositoryFile();
        System.out.println("=== Lista de zonas del empleado "+empleado.getNombre()+" ===");
        zoneRepository.listarZonas(empleado.getZonasAsignadas());
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        userRepository.eliminarUsuario(empleado);
    }

    @Override
    public boolean eliminarEmpleadoPorDni(int DNI) {
        Empleado empleadoAux;
        
        empleadoAux = buscarEmpleadoPorDni(DNI);
        
        if(empleadoAux != null){
            eliminarEmpleado(empleadoAux);
            return true;
        } else {
            System.out.println("No se encontró el empleado DNI: "+ DNI +":");
            return false;
        }    
    }

    @Override
    public boolean eliminarEmpleadoPorCodigo(int codigo) {
        Empleado empleadoAux;
        
        empleadoAux = buscarEmpleadoPorCodigo(codigo);
        
        if(empleadoAux != null){
            eliminarEmpleado(empleadoAux);
            return true;
        } else {
            System.out.println("No se encontró el empleado codigo: "+ codigo +":");
            return false;
        }    
    }
    
    @Override
    public void asignarEmpleadoZona(Empleado empleado, Zona zona){
        
    }
}
