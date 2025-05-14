package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "socios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Socio {

    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private Date fecha_nacimiento;
    private String email;
    private String telefono;
}
