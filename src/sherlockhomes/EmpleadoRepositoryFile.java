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
    public void crearEmpleado(String nombre, int DNI, String direccion, String telefono, String especialidad){ 
        int ultimoId = userRepository.ultimoUsuario();
        
        Empleado empleado = new Empleado(ultimoId, nombre, DNI, direccion, telefono, especialidad);

        userRepository.agregarUsuario(empleado);
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
        return (buscarEmpleadoPorDni(DNI) != null);
    }
    
    @Override
    public boolean existeEmpleadoPorCodigo(int codigo){
        return (buscarEmpleadoPorCodigo(codigo) != null);
    }
    
    @Override
    public void modificarEmpleadoPorDni(int DNI, String direccion, String telefono, String especialidad){
        empleados = cargarEmpleados();
        
        Empleado empleado =  buscarEmpleadoPorDni(DNI);
        
        if(!direccion.isBlank()){empleado.setDireccion(direccion);}
        if(!direccion.isBlank()){empleado.setTelefono(telefono);}
        if(!especialidad.isBlank()){empleado.setEspecialidad(especialidad);}
          
        userRepository.modificarEmpleado(empleado);
    }
    
    @Override
    public void modificarEmpleadoPorCodigo(int codigo, String direccion, String telefono, String especialidad){
        modificarEmpleadoPorDni(buscarEmpleadoPorCodigo(codigo).getDNI(),direccion, telefono, especialidad);
    }
    
    @Override
    public void asignarEmpleadoZona(int codigo, Zona zona){
        Empleado empleado = buscarEmpleadoPorCodigo(codigo);
                
        empleado.asignarZona(zona);
        
        userRepository.modificarEmpleado(empleado);
    }
    
    @Override
    public void asignarEmpleadoVehiculo(int codigo, Vehiculo vehiculo){
        Empleado empleado = buscarEmpleadoPorCodigo(codigo);
                
        empleado.asignarVehiculo(vehiculo);
        
        userRepository.modificarEmpleado(empleado);
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
        vehicleRepository.listarVehiculos(empleado.getVehiculosAsignados());
    }

    @Override
    public void listarEmpleadoZonas(Empleado empleado) {
        zoneRepository = new ZonaRepositoryFile();
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
    
 
}
