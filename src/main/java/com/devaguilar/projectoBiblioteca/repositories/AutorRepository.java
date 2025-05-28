package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT a  " +
            "FROM Autor a WHERE CONCAT(apellido, ' ', nombre) LIKE %:fullname%")
    List<Autor> getByFullName(@Param("fullname") String fullName);

}
