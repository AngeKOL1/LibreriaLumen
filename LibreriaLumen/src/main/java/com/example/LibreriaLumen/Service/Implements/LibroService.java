package com.example.LibreriaLumen.Service.Implements;

import com.example.LibreriaLumen.Models.Libro;
import com.example.LibreriaLumen.Repositorios.IGenericRepo;
import com.example.LibreriaLumen.Repositorios.LibroRepo;
import com.example.LibreriaLumen.Service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroService extends GenericService<Libro, Integer> implements ILibroService {
    private final LibroRepo repo;
    @Override
    protected IGenericRepo<Libro, Integer> getRepo(){
        return repo;
    }
}
