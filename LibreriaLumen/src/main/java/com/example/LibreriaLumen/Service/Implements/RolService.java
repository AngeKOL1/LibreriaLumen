package com.example.LibreriaLumen.Service.Implements;

import com.example.LibreriaLumen.Models.Rol;
import com.example.LibreriaLumen.Models.Usuario;
import com.example.LibreriaLumen.Repositorios.IGenericRepo;
import com.example.LibreriaLumen.Repositorios.RolRepo;
import com.example.LibreriaLumen.Repositorios.UsuarioRepo;
import com.example.LibreriaLumen.Service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolService extends GenericService<Rol, Integer> implements IRolService {
    private final RolRepo repo;
    @Override
    protected IGenericRepo<Rol, Integer> getRepo(){
        return repo;
    }
}
