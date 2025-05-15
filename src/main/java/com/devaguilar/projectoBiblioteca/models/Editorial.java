package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "editoriales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editorial extends Base{

    private String nombre;
    @ManyToMany(mappedBy = "editoriales")
    private List<Libro> libros;
}
