package sherlockhomes;

import java.util.ArrayList;

interface GarageRepository {
    
    public boolean crearGarage(Zona zona);
    public Garage buscarGaragePorNumero(int numero);
    public ArrayList<Garage> buscarGaragePorSocio(Socio socio);
    public boolean existeGaragePorNumero(int numero);
    public boolean tieneVehiculoAsignado(int numero);
    public void asignarGarageVehiculo(int garage, String patente);
    public void quitarGarageVehiculo(int garage);
    public void quitarVehiculoGarage(String patente);
    public void mostrarGarage(Garage garage);
    public void listarGaragesAll();
    public void listarGarages(ArrayList<Garage> garage);
    
}
