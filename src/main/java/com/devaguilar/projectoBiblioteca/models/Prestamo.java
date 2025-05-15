package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "prestamos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo extends Base{

    private Date fechaPrestamo;
    private Date fecha_limite;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
}
