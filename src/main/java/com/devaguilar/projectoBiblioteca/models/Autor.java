package com.devaguilar.projectoBiblioteca.models;

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
public class Autor extends Base{

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

    public enum Sexo {
        MASCULINO, FEMENINO
    }
}