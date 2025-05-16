package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;

    public enum EstadoPrestamo {
        ACTIVO,
        DEVUELTO
    }
}


