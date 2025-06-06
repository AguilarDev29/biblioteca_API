package com.devaguilar.projectoBiblioteca.models.editorial;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.editorial.dto.DtoEditorialCreateUpdate;
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
@Table(name = "editoriales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editorial extends Base {
    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String nombre;
    @ManyToMany(mappedBy = "editoriales")
    private List<Libro> libros;

    public Editorial(DtoEditorialCreateUpdate editorial) {
        this.nombre = editorial.nombre();
    }
}
