package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT CONCAT(apellido, ' ', nombre) AS fullName " +
            "FROM autores WHERE fullName = :fullName", nativeQuery = true)
    List<Autor> findByApellidoAndNombre(String fullName);

}
