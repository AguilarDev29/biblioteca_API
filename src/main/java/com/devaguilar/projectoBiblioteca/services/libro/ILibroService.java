package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.Libro;
import java.util.List;


public interface ILibroService {

    Libro getLibroById(Long id);

    List<Libro> getAllLibros();

    List<Libro> getByTitulo(String titulo);

    List<Libro> getByAutor(String autor);

    List<Libro> getByGenero(String genero);

    List<Libro> getByEditorial(String editorial);

    List<Libro> getByFormato(String formato);

    Libro saveLibro(Libro libro);

    Libro updateLibro(Libro libro);

    void deleteLibro(Long id);

    String updateStock(Long id, int stock);
}
