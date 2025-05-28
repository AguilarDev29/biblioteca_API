package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import java.util.List;


public interface ILibroService {

    Libro getLibroById(Long id);

    List<Libro> getAllLibros();

    List<Libro> getByTitulo(String titulo);

    List<Libro> getByAutor(String autor);

    List<Libro> getByGenero(String genero);

    List<Libro> getByEditorial(String editorial);

    List<Libro> getByFormato(Libro.TipoFormato formato);

    Libro saveLibro(Libro libro);

    Libro updateLibro(Libro libro, Long id);

    void deleteLibro(Long id);

    String updateStock(Long id, int stock);

    Libro addGenero(Long id, Long idGenero);

    Libro addAutor(Long id, Long idAutor);

    Libro addEditorial(Long id, Long idEditorial);

    Libro addFormato(Long idLibro, Libro.TipoFormato formato);

    Libro removeGenero(Long id, Long idGenero);

    Libro removeAutor(Long id, Long idAutor);

    Libro removeEditorial(Long id, Long idEditorial);

    Libro removeFormato(Long idLibro, String formato);
}
