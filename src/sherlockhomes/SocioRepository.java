package sherlockhomes;

import java.util.ArrayList;

public interface SocioRepository {
    public boolean crearSocio(String nombre, int dni, String direccion, String telefono);
    public Socio buscarSocioPorDni(int DNI);
    public boolean existeSocioPorDni(int DNI);
    public boolean modificarSocioPorDni(int DNI, String direccion, String telefono);
    public void mostrarSocio(Socio socio);
    public void mostrarSocioPorDni(int DNI);
    public void listarSociosAll();
    public void listarSocios(ArrayList<Socio> socios);
    public void listarSocioVehiculos(Socio socio);
    public void listarSocioGarages(Socio socio);
    public void eliminarSocio(Socio socio);
    public boolean eliminarSocioPorDni(int DNI);

}
