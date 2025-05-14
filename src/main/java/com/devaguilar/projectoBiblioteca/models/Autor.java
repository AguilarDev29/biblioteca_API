package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "autores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {

    private Long id;
    private String apellido;
    private String nombre;
    private Sexo sexo;
    private Date fechaNacimiento;
    private Date fechaDefuncion;
    private String nacionalidad;
}

enum Sexo {
    MASCULINO, FEMENINO
}