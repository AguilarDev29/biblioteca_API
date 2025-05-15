package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "socios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Socio extends Base{

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fecha_nacimiento;
    private String email;
    private String telefono;
    @OneToMany(mappedBy = "socio")
    private List<Prestamo> prestamos;
}
