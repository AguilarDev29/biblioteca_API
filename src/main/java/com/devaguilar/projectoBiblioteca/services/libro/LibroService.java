package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.Libro;
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
    public List<Libro> getLibroByTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo.toLowerCase())
                .stream().map(l -> l.getTitulo()
                        .contains(titulo) ? l : null).toList();
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public void saveLibro(Libro libro) {
        libroRepository.save(libro);
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
        var optionalLibro = libroRepository.findById(id);
        if(optionalLibro.isPresent()) {
            optionalLibro.get().setStock(stock);
            libroRepository.save(optionalLibro.get());
            return "Stock actualizado: " + optionalLibro.get()
                    .getStock() + " unidades";
        }
        return "Stock no actualizado";
    }
}
