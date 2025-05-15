package com.devaguilar.projectoBiblioteca.services.genero;

import com.devaguilar.projectoBiblioteca.models.Genero;
import java.util.List;

public interface IGeneroService {

    List<Genero> getAllGenero();

    void saveGenero(Genero genero);

    Genero updateGenero(Genero genero);

    void deleteGeneroByNombre(String nombre);
}
