package sherlockhomes;

import java.util.ArrayList;

public interface SocioRepository {
    public void crearSocio(String nombre, int dni, String direccion, String telefono);
    public Socio buscarSocioPorDni(int DNI);
    public boolean existeSocioPorDni(int DNI);
    public void modificarSocioPorDni(int DNI, String direccion, String telefono);
    public void comprarGarage(int DNI, Garage garage);
    public void asignarSocioVehiculo(int DNI, Vehiculo vehiculo);
    public void quitarVehiculoPorPatente(String patente);
    public void mostrarSocio(Socio socio);
    public void mostrarSocioPorDni(int DNI);
    public void listarSociosAll();
    public void listarSocios(ArrayList<Socio> socios);
    public void listarSocioVehiculos(Socio socio);
    public void listarSocioGarages(Socio socio);
    public void eliminarSocio(Socio socio);
    public void eliminarSocioPorDni(int DNI);

}
