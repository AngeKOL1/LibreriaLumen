package com.example.LibreriaLumen.Service;

import java.util.List;

public interface IGenericService<T, ID> {
    T save(T t) throws Exception;
    List<T> saveAll(List<T> entities) throws Exception;
    T update(T t, ID id) throws Exception;
    List<T> findAll() throws Exception;
    T findById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}

