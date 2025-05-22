package com.devaguilar.projectoBiblioteca.models.autor.dto;

import java.time.LocalDate;

public record DtoAutorCreateUpdate(
        String apellido,
        String nombre,
        String sexo,
        LocalDate fechaNacimiento,
        LocalDate fechaDefuncion,
        String nacionalidad
) {
}
