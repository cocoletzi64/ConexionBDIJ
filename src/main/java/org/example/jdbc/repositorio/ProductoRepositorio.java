package org.example.jdbc.repositorio;

import java.util.List;

public interface ProductoRepositorio <T>{
    List<T> listar();
    T porId(Long id);


    void guardar(T t);
    void eliminar(Long id);
}
