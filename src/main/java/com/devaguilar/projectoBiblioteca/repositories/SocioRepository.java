package com.devaguilar.projectoBiblioteca.repositories;

import com.devaguilar.projectoBiblioteca.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    Optional<Socio> findByDni(String dni);
}
