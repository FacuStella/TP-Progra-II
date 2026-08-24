package sherlockhomes;

import java.util.ArrayList;

interface GarageRepository {
    
    public void crearGarage(Zona zona);
    public int ultimoGarage();
    public Garage buscarGaragePorNumero(int numero);
    public ArrayList<Garage> buscarGaragePorSocio(Socio socio);
    public boolean existeGaragePorNumero(int numero);
    public boolean tieneVehiculoAsignado(int numero);
    public boolean tienePropietario(int numero);
    public void asignarGarageVehiculo(int garage, String patente);
    public void quitarGarageVehiculo(int garage);
    public void quitarVehiculoGarage(String patente);
    public void mostrarGarage(Garage garage);
    public void listarGaragesAll();
    public void listarGarages(ArrayList<Garage> garage);
    public void eliminarSocio(Socio socio);
    
}
