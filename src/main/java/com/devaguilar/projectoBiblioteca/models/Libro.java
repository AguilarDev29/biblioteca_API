package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Libro extends Base{
    @NotBlank
    @Max(50)
    @Column(length = 50)
    private String titulo;
    @NotBlank
    @Max(255)
    @Column(length = 255)
    private String descripcion;
    @Future(message = "La fecha de publicación debe ser futura")
    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    private Integer stock = 0;
    @ManyToMany
    @JoinTable(name = "generos_libros",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "autores_libros",
    joinColumns = @JoinColumn(name = "id_libro"),
    inverseJoinColumns = @JoinColumn(name = "id_autor"))
    @NotNull
    private Set<Autor> autores = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "editoriales_libros",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_editorial"))
    private Set<Editorial> editoriales = new HashSet<>();
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Set<TipoFormato> formatos = new HashSet<>();
    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos;

    public enum TipoFormato{
        DIGITAL, FISICO, AUDIOLIBRO
    }
}

