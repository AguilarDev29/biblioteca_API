package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTitulo(String titulo);

    List<Libro> findByGenerosNombreContains(String genero);

    List<Libro> findByEditorialesNombreContains(String editorial);

    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE" +
            " CONCAT(a.apellido, ' ', a.nombre) LIKE %:fullname%")
    List<Libro> getByAutorFullName(@Param("fullname") String fullname);

    List<Libro> findByFormatosContains(Libro.TipoFormato formato);
}
