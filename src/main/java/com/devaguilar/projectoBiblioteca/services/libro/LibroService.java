package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import com.devaguilar.projectoBiblioteca.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> getByTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    @Override
    public List<Libro> getByAutor(String autor) {
        return libroRepository.getByAutorFullName(autor);
    }

    @Override
    public List<Libro> getByGenero(String genero) {
        return libroRepository.findByGeneroNombre(genero);
    }

    @Override
    public List<Libro> getByEditorial(String editorial) {
        return libroRepository.findByEditorialNombre(editorial);
    }

    @Override
    public List<Libro> getByFormato(String formato) {
        return libroRepository.findByFormatos(formato);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro updateLibro(Libro libro) {
        var libroToUpdate = libroRepository.findById(libro.getId());
        if (libroToUpdate.isPresent()) {

            if(libro.getTitulo() != null) libroToUpdate.get()
                    .setTitulo(libro.getTitulo());
            if(libro.getDescripcion() != null) libroToUpdate.get()
                    .setDescripcion(libro.getDescripcion());
            if(libro.getFechaPublicacion() != null) libroToUpdate.get()
                    .setFechaPublicacion(libro.getFechaPublicacion());
            if(libro.getGeneros() != null) libroToUpdate.get()
                    .setGeneros(libro.getGeneros());
            if(libro.getAutores() != null) libroToUpdate.get()
                    .setAutores(libro.getAutores());
            if(libro.getEditoriales() != null) libroToUpdate.get()
                    .setEditoriales(libro.getEditoriales());
            if(libro.getFormatos() != null) libroToUpdate.get()
                    .setFormatos(libro.getFormatos());

            return libroRepository.save(libro);
        }
        return null;
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public String updateStock(Long id, int stock) {
        var libroToUpdate = libroRepository.findById(id);
        if(libroToUpdate.isPresent()) {
            libroToUpdate.get().setStock(libroToUpdate.get().getStock() + stock);
            libroRepository.save(libroToUpdate.get());
            return "Stock actualizado: " + libroToUpdate.get()
                    .getStock() + " unidades";
        }
        return "Stock no actualizado";
    }
}
