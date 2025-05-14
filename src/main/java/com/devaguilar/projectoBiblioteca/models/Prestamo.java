package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "prestamos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Prestamo {
    private Long id;
    private Date fechaPrestamo;
    private Date fecha_limite;
    private Socio socio;
    private Libro libro;
}
