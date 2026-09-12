package daos;

import daos.GerericDAO;
import daos.GenericIntDAO;
import models.Zona;
import models.Vehiculo;
import models.Empleado;

public interface EmpleadoDAO extends GerericDAO<Empleado>,GenericIntDAO<Empleado,Integer>{
    public int ultimoEmpleado();
    public void asignarEmpleadoZona(int codigo, Zona zona);
    public void asignarEmpleadoVehiculo(int codigo, Vehiculo vehiculo);
    public void quitarEmpleadoZona(int codigo, Zona zona);
    public void quitarEmpleadoVehiculo(int codigo, Vehiculo vehiculo);
    public void listarEmpleadoVehiculos(Empleado empleado);
    public void listarEmpleadoZonas(Empleado empleado);
}
