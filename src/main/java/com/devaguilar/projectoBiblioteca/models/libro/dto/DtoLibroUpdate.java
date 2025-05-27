package com.devaguilar.projectoBiblioteca.models.libro.dto;

import java.time.LocalDate;

public record DtoLibroUpdate(
    String titulo,
    String descripcion,
    LocalDate fechaPublicacion
) {
}
