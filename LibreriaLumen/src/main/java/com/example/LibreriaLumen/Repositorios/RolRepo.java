package com.example.LibreriaLumen.Repositorios;

import com.example.LibreriaLumen.Models.Rol;
import com.example.LibreriaLumen.Models.Usuario;

import java.util.Optional;

public interface RolRepo extends IGenericRepo<Rol, Integer> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
