package com.devaguilar.projectoBiblioteca.models.prestamo.dto;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import com.devaguilar.projectoBiblioteca.models.socio.Socio;

public record DtoPrestamoUpdate(
        Socio socio,
        Libro libro
) {
}
