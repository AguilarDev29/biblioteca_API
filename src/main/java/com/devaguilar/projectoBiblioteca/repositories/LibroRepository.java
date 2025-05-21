package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTitulo(String titulo);

    List<Libro> findByGeneroNombre(String genero);

    List<Libro> findByEditorialNombre(String editorial);

    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE" +
            " CONCAT(a.apellido, ' ', a.nombre) = LIKE%?1%")
    List<Libro> getByAutorFullName(String fullname);

    List<Libro> findByFormatos(String formato);
}
