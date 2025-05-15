package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Base{

    private String apellido;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;
    private String nacionalidad;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}

enum Sexo {
    MASCULINO, FEMENINO
}