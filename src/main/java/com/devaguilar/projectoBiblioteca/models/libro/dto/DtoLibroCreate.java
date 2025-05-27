package com.devaguilar.projectoBiblioteca.models.libro.dto;

import com.devaguilar.projectoBiblioteca.models.autor.Autor;
import com.devaguilar.projectoBiblioteca.models.editorial.Editorial;
import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import com.devaguilar.projectoBiblioteca.models.libro.Libro;

import java.time.LocalDate;
import java.util.List;

public record DtoLibroCreate(
        String titulo,
        String descripcion,
        LocalDate fechaPublicacion,
        List<Genero> generos,
        List<Autor> autores,
        List<Editorial> editoriales,
        List<Libro.TipoFormato> formatos
) {
}
