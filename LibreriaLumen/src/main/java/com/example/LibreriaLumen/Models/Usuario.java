package com.example.LibreriaLumen.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(nullable = false, unique = true,  length = 100)
    private String correo;
    @Column(nullable = false, length = 200)
    private String contrasena;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    private Integer edad;
    private boolean estado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UsuarioRol> usuarioRoles = new ArrayList<>();

}
