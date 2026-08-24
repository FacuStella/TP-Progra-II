package sherlockhomes;

import java.util.ArrayList;

public interface Repository<Object, Integer> {
    public void crear(Object t);
    public Socio buscarPorValor(Integer i);
    public boolean existePorValor(Integer i);
    public void modificarPorValor(Integer i, Object t);
    public void mostrar(Object t);
    public void mostrarPorValor(Integer i);
    public void listarAll();
    public void listar(ArrayList<Object> list);
    public void eliminar(Object t);
    public void eliminarPorValor(Integer i);
}