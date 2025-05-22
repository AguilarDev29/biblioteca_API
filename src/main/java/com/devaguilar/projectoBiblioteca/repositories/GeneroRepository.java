package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Optional<Genero> findByNombre(String nombre);

    List<Genero> findByLibrosTitulo(String titulo);
}
