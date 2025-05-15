package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.Libro;
import java.util.List;


public interface ILibroService {

    List<Libro> getLibroByTitulo(String titulo);

    List<Libro> getAllLibros();

    void saveLibro(Libro libro);

    Libro updateLibro(Libro libro);

    void deleteLibro(Long id);

    String updateStock(Long id, int stock);
}
