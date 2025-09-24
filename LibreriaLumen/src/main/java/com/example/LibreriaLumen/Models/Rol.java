package com.example.LibreriaLumen.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="rol")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(nullable = false, length = 40)
    private String nombreRol;
    @Column(nullable = false, length = 200)
    private String descripcionRol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UsuarioRol> usuarioRoles = new ArrayList<>();
}
