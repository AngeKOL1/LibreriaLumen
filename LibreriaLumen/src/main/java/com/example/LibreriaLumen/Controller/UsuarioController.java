package com.example.LibreriaLumen.Controller;

import com.example.LibreriaLumen.Models.Usuario;
import com.example.LibreriaLumen.Service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final IUsuarioService service;
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() throws Exception{
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id) throws Exception{
        Usuario obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws Exception{
        Usuario obj =  service.save(usuario);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).build();
    }
}