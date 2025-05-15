package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByApellidoAndNombre(String fullName);

}
