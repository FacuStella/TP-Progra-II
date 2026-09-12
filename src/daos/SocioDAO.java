package daos;

import daos.GerericDAO;
import daos.GenericIntDAO;
import models.Vehiculo;
import models.Garage;
import models.Socio;

public interface SocioDAO extends GerericDAO<Socio>,GenericIntDAO<Socio,Integer> {
    public void comprarGarage(int DNI, Garage garage);
    public void asignarSocioVehiculo(int DNI, Vehiculo vehiculo);
    public void quitarVehiculoPorPatente(String patente);
    public void listarSocioVehiculos(Socio socio);
    public void listarSocioGarages(Socio socio);
    public boolean tieneGarages(Socio propietario);
}
