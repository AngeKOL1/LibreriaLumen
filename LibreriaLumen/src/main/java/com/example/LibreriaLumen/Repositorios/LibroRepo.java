package com.example.LibreriaLumen.Repositorios;

import com.example.LibreriaLumen.Models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface LibroRepo extends IGenericRepo<Libro, Integer> {

}
