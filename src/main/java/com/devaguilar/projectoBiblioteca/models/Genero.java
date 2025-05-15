package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "generos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genero extends Base{

    private String nombre;
    @ManyToMany(mappedBy = "generos")
    private List<Libro> libros;
}
