package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    List<Editorial> findByNombre(String nombre);
}
