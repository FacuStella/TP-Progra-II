package sherlockhomes;

import java.util.ArrayList;

public interface EmpleadoRepository {
    public boolean crearEmpleado(String nombre, int dni, String direccion, String telefono, String especialidad);
    public Empleado buscarEmpleadoPorDni(int DNI);
    public Empleado buscarEmpleadoPorCodigo(int codigo);
    public boolean existeEmpleadoPorDni(int DNI);
    public boolean existeEmpleadoPorCodigo(int codigo);
    public void modificarEmpleadoPorDni(int DNI, String direccion, String telefono, String especialidad);
    public void modificarEmpleadoPorCodigo(int codigo, String direccion, String telefono, String especialidad);
    public void asignarEmpleadoZona(int codigo, Zona zona);
    public void asignarEmpleadoVehiculo(int codigo, Vehiculo vehiculo);
    public void mostrarEmpleado(Empleado empleado);
    public void mostrarEmpleadoPorDni(int DNI);
    public void mostrarEmpleadoPorCodigo(int codigo);
    public void listarEmpleadosAll();
    public void listarEmpleados(ArrayList<Empleado> empleados);
    public void listarEmpleadoVehiculos(Empleado empleado);
    public void listarEmpleadoZonas(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
    public boolean eliminarEmpleadoPorDni(int DNI);
    public boolean eliminarEmpleadoPorCodigo(int codigo);


}
