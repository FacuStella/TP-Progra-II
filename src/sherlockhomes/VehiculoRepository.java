package sherlockhomes;

import java.util.ArrayList;

interface VehiculoRepository {
    public boolean crearVehiculo(String patente, String marca, String tipo, String dimensiones, Socio socio);
    public Vehiculo buscarVehiculoPorPatente(String patente);
    public boolean existeVehiculoPorPatente(String patente);
    public boolean tieneGarageAsignado(String patente);
    public void asignarVehiculoGarage(String patente, int garage);
    public void quitarGarageVehiculo(int numero);
    public void quitarVehiculoGarage(String patente);
    public void mostrarVehiculo(Vehiculo vehiculo);
    public void mostrarVehiculoPorPatente(String patente);
    public void mostrarVehiculoGarage(Vehiculo vehiculo);
    public void listarVehiculosAll();
    public void listarVehiculos(ArrayList<Vehiculo> vehiculo);
    public void eliminarVehiculo(Vehiculo vehiculo);
    public boolean eliminarVehiculoPorPatente(String patente);
}
