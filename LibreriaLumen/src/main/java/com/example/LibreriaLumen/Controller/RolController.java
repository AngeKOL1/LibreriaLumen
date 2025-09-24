package com.example.LibreriaLumen.Controller;

import com.example.LibreriaLumen.Models.Rol;
import com.example.LibreriaLumen.Models.Usuario;
import com.example.LibreriaLumen.Service.IRolService;
import com.example.LibreriaLumen.Service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RolController {
    private final IRolService service;
    @GetMapping
    public ResponseEntity<List<Rol>> findAll() throws Exception{
        List<Rol> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable("id") Integer id) throws Exception{
        Rol obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Rol> save(@RequestBody Rol rol) throws Exception{
        Rol obj =  service.save(rol);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdRol()).toUri();
        return ResponseEntity.created(location).build();
    }
}
