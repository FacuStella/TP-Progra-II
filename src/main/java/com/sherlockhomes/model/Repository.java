package com.sherlockhomes.model;

import java.util.ArrayList;

public interface Repository<Object, Integer>  {
    public void crear(Object t);
    public Object buscarPorValor(Integer v, Integer p);
    public boolean existePorValor(Integer v, Integer p);
    public void modificarPorValor(Integer v, Integer p, Object t);
    public void mostrar(Object t);
    public void mostrarPorValor(Integer v, Integer p);
    public void listarAll();
    public void listar(ArrayList<Object> list);
    public void eliminar(Object t);
    public void eliminarPorValor(Integer v, Integer p);
}