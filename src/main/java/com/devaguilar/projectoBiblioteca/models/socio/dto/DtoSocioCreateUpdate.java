package com.devaguilar.projectoBiblioteca.models.socio.dto;

import java.time.LocalDate;

public record DtoSocioCreateUpdate(
        String apellido,
        String nombre,
        String dni,
        LocalDate fechaNacimiento,
        String email,
        String telefono
) {
}
