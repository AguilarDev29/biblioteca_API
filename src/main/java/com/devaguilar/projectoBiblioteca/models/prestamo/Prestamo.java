package com.devaguilar.projectoBiblioteca.models.prestamo;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.socio.Socio;
import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prestamos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo extends Base {
    @NotBlank
    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo = LocalDateTime.now();
    @Column(name = "fecha_limite")
    private LocalDateTime fechaLimite = fechaPrestamo.plusDays(14);
    @Enumerated(EnumType.STRING)
    @NotBlank
    private EstadoPrestamo estado = EstadoPrestamo.ACTIVO;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    @NotNull
    private Socio socio;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    @NotNull
    private Libro libro;

    public enum EstadoPrestamo {
        ACTIVO,
        DEVUELTO
    }


}


