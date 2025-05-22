package com.devaguilar.projectoBiblioteca.models.autor;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.autor.dto.DtoAutorCreateUpdate;
import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Base {

    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String apellido;
    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String nombre;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Sexo sexo;
    @NotBlank
    @Future(message = "La fecha de nacimiento no puede ser futura")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Future(message = "La fecha de defunción no puede ser futura")
    @Column(name = "fecha_defuncion")
    private LocalDate fechaDefuncion;
    @NotBlank
    @Max(50)
    @Column(length = 50)
    private String nacionalidad;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor(DtoAutorCreateUpdate autor) {
        this.apellido = autor.apellido();
        this.nombre = autor.nombre();
        this.sexo = autor.sexo().equals("MASCULINO") ? Sexo.MASCULINO : Sexo.FEMENINO;
        this.fechaNacimiento = autor.fechaNacimiento();
        this.fechaDefuncion = autor.fechaDefuncion();
        this.nacionalidad = autor.nacionalidad();
    }

    public enum Sexo {
        MASCULINO, FEMENINO
    }
}