package com.devaguilar.projectoBiblioteca.models.libro;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.libro.dto.DtoLibroCreate;
import com.devaguilar.projectoBiblioteca.models.libro.dto.DtoLibroUpdate;
import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;
import com.devaguilar.projectoBiblioteca.models.autor.Autor;
import com.devaguilar.projectoBiblioteca.models.editorial.Editorial;
import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Libro extends Base {
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
    private List<Genero> generos = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "autores_libros",
    joinColumns = @JoinColumn(name = "id_libro"),
    inverseJoinColumns = @JoinColumn(name = "id_autor"))
    @NotNull
    private List<Autor> autores = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "editoriales_libros",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_editorial"))
    private List<Editorial> editoriales = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    @NotBlank
    private List<TipoFormato> formatos = new ArrayList<>();
    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos = new ArrayList<>();

    public Libro(DtoLibroCreate libro) {
        this.titulo = libro.titulo();
        this.descripcion = libro.descripcion();
        this.fechaPublicacion = libro.fechaPublicacion();
        this.generos = libro.generos();
        this.autores = libro.autores();
        this.editoriales = libro.editoriales();
        this.formatos = libro.formatos();
    }

    public Libro(DtoLibroUpdate libro) {
        this.titulo = libro.titulo();
        this.descripcion = libro.descripcion();
        this.fechaPublicacion = libro.fechaPublicacion();
    }

    public enum TipoFormato{
        DIGITAL, FISICO, AUDIOLIBRO
    }
}

