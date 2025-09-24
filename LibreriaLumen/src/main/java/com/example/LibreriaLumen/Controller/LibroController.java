package com.example.LibreriaLumen.Controller;

import com.example.LibreriaLumen.Models.Libro;
import com.example.LibreriaLumen.Service.ILibroService;
import com.example.LibreriaLumen.Service.Implements.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libros")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService service;

    @GetMapping
    public ResponseEntity<List<Libro>> findAll() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro libro) throws Exception {
        Libro obj = service.save(libro);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdLibro()).toUri();
        return ResponseEntity.created(location).body(obj);
    }
    @PostMapping("/bulk")
    public List<Libro> saveAll(@RequestBody List<Libro> libros) throws Exception {
        return service.saveAll(libros);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(
            @PathVariable Integer id,
            @RequestBody Libro libro) throws Exception {

        Libro actualizado = service.update(libro, id);
        return ResponseEntity.ok(actualizado);
    }
}



