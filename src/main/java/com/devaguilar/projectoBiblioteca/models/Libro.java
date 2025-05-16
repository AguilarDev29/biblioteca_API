package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.*;
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

    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private Integer stock;
    @ManyToMany
    @JoinTable(name = "generos_libros",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "autores_libros",
    joinColumns = @JoinColumn(name = "id_libro"),
    inverseJoinColumns = @JoinColumn(name = "id_autor"))
    private Set<Autor> autores = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "editoriales_libros",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_editorial"))
    private Set<Editorial> editoriales = new HashSet<>();
    private Set<TipoFormato> formatos = new HashSet<>();
    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos;

    public enum TipoFormato{
        DIGITAL, FISICO, AUDIOLIBRO
    }
}

