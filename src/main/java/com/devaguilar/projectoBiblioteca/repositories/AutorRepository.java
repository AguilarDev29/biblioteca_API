package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT a  " +
            "FROM autores a WHERE CONCAT(apellido, ' ', nombre) = LIKE %?1%")
    List<Autor> getByFullName(String fullName);

}
