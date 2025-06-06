package com.devaguilar.projectoBiblioteca.models.socio;

import com.devaguilar.projectoBiblioteca.models.Base;
import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;
import com.devaguilar.projectoBiblioteca.models.socio.dto.DtoSocioCreateUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "socios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Socio extends Base {
    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String apellido;
    @NotBlank
    @Max(100)
    @Column(length = 100)
    private String nombre;
    @NotBlank
    @Min(7)
    @Max(10)
    @Column(unique = true, length = 10)
    private String dni;
    @Future(message = "La fecha de nacimiento no puede ser futura")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Email
    private String email;
    @Column(length = 20)
    private String telefono;
    @OneToMany(mappedBy = "socio")
    private List<Prestamo> prestamos;

    public Socio(DtoSocioCreateUpdate socio) {
        this.apellido = socio.apellido();
        this.nombre = socio.nombre();
        this.dni = socio.dni();
        this.fechaNacimiento = socio.fechaNacimiento();
        this.email = socio.email();
        this.telefono = socio.telefono();
    }
}
