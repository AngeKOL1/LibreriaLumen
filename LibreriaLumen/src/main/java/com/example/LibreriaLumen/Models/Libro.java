package com.example.LibreriaLumen.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="libro")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Libro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idLibro;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String autor;
    @Column(nullable = false)
    private float precio;
    @Column(nullable = false, length = 500)
    private String imagenURL;
    @Column(nullable = false)
    private Integer stock;
}
