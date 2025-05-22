package com.devaguilar.projectoBiblioteca.services.genero;

import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import java.util.List;

public interface IGeneroService {

    List<Genero> getAllGenero();

    List<Genero> getGeneroByLibro(String libro);

    Genero saveGenero(Genero genero);

    Genero updateGenero(Genero genero);

    void deleteGeneroByNombre(String nombre);
}
