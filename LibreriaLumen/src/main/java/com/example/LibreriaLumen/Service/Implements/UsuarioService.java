package com.example.LibreriaLumen.Service.Implements;

import com.example.LibreriaLumen.Models.Libro;
import com.example.LibreriaLumen.Models.Rol;
import com.example.LibreriaLumen.Models.Usuario;
import com.example.LibreriaLumen.Models.UsuarioRol;
import com.example.LibreriaLumen.Repositorios.IGenericRepo;
import com.example.LibreriaLumen.Repositorios.LibroRepo;
import com.example.LibreriaLumen.Repositorios.RolRepo;
import com.example.LibreriaLumen.Repositorios.UsuarioRepo;
import com.example.LibreriaLumen.Service.IUsuarioService;
import com.example.LibreriaLumen.exception.ResponseExceptionHandler;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UsuarioService extends GenericService<Usuario, Integer> implements IUsuarioService {
    private final UsuarioRepo repo;
    private final RolRepo rolRepo;
    @Override
    protected IGenericRepo<Usuario, Integer> getRepo(){
        return repo;
    }

    @Override
    public Usuario save(Usuario usuario) {
        Rol rolUsuario = rolRepo.findByNombreRol("USUARIO")
                .orElseThrow(() -> new RuntimeException("Rol USUARIO no encontrado"));

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rolUsuario);
        usuarioRol.setActivo(true);
        usuarioRol.setFechaAsignacion(LocalDate.now());
        usuario.getUsuarioRoles().add(usuarioRol);

        return repo.save(usuario);
    }

}
