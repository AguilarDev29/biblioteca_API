package com.devaguilar.projectoBiblioteca.models.genero;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "generos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genero extends Base {
    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String nombre;
    @ManyToMany(mappedBy = "generos")
    private List<Libro> libros;
}
