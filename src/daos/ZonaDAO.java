package daos;

import daos.GerericDAO;
import daos.GenericStringDAO;
import models.Zona;
import models.Empleado;

public interface ZonaDAO extends GerericDAO<Zona>, GenericStringDAO<Zona,Integer,String> {
    public void listarZonaGarages(Zona zona);
    public void asignarZonaEmpleado(String letra, int codigo);
    public void quitarZonaEmpleado(String letra, Empleado empleado);
}
