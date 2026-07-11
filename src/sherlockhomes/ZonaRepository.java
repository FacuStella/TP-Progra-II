package sherlockhomes;

import java.util.ArrayList;

public interface ZonaRepository {
    public boolean crearZona(String letra, int contadorLuz, String ancho, String profundidad);
    public Zona buscarZonaPorLetra(String letra);
    public boolean existeZonaPorLetra(String letra);
    public void mostrarZona(Zona zona);
    public void listarZonasAll();
    public void listarZonas(ArrayList<Zona> zonas);
    public void listarZonaGarages(Zona zona);
}
