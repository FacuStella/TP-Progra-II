package daos;

import daos.GerericDAO;
import daos.GenericStringDAO;
import models.Vehiculo;
import models.Empleado;

public interface VehiculoDAO extends GerericDAO<Vehiculo>,GenericStringDAO<Vehiculo,Integer,String> {
    public boolean tieneGarageAsignado(String patente);
    public boolean tieneEmpleadoAsignado(String patente);
    public void asignarVehiculoGarage(String patente, int garage);
    public void asignarVehiculoEmpleado(String patente, Empleado empleado);
    public void quitarGarageVehiculo(int numero);
    public void quitarVehiculoGarage(String patente);
    public void quitarVehiculoEmpleado(String patente);
    public void mostrarVehiculoGarage(Vehiculo vehiculo);
}
