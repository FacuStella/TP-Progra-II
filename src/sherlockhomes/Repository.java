package sherlockhomes;

import java.util.ArrayList;

public interface Repository<Object, Integer, String>  {
    public void crear(Object t);
    public Object buscarPorValor(Integer v, Integer p);
    public Object buscarPorValorS(String v, Integer p);
    public boolean existePorValor(Integer v, Integer p);
    public boolean existePorValorS(String v, Integer p);
    public void modificarPorValor(Integer v, Integer p, Object t);
    public void modificarPorValorS(String v, Integer p, Object t);
    public void mostrar(Object t);
    public void mostrarPorValor(Integer v, Integer p);
    public void mostrarPorValorS(String v, Integer p);
    public void listarAll();
    public void listar(ArrayList<Object> list);
    public void eliminar(Object t);
    public void eliminarPorValor(Integer v, Integer p);
    public void eliminarPorValorS(String v, Integer p);
}