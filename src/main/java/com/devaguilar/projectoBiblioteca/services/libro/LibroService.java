package com.devaguilar.projectoBiblioteca.services.libro;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import com.devaguilar.projectoBiblioteca.repositories.AutorRepository;
import com.devaguilar.projectoBiblioteca.repositories.EditorialRepository;
import com.devaguilar.projectoBiblioteca.repositories.GeneroRepository;
import com.devaguilar.projectoBiblioteca.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService {

    private final LibroRepository libroRepository;
    private final GeneroRepository generoRepository;
    private final AutorRepository autorRepository;
    private final EditorialRepository editorialRepository;

    public LibroService(LibroRepository libroRepository, GeneroRepository generoRepository, AutorRepository autorRepository, EditorialRepository editorialRepository) {
        this.libroRepository = libroRepository;
        this.generoRepository = generoRepository;
        this.autorRepository = autorRepository;
        this.editorialRepository = editorialRepository;
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
        return libroRepository.findByGenerosNombreContains(genero);
    }

    @Override
    public List<Libro> getByEditorial(String editorial) {
        return libroRepository.findByEditorialesNombreContains(editorial);
    }

    @Override
    public List<Libro> getByFormato(Libro.TipoFormato formato) {
        return libroRepository.findByFormatosContains(formato);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro updateLibro(Libro libro, Long id) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {

            if (libro.getTitulo() != null) libroToUpdate.get()
                    .setTitulo(libro.getTitulo());
            if (libro.getDescripcion() != null) libroToUpdate.get()
                    .setDescripcion(libro.getDescripcion());
            if (libro.getFechaPublicacion() != null) libroToUpdate.get()
                    .setFechaPublicacion(libro.getFechaPublicacion());
            if (libro.getGeneros() != null) libroToUpdate.get()
                    .setGeneros(libro.getGeneros());
            if (libro.getAutores() != null) libroToUpdate.get()
                    .setAutores(libro.getAutores());
            if (libro.getEditoriales() != null) libroToUpdate.get()
                    .setEditoriales(libro.getEditoriales());
            if (libro.getFormatos() != null) libroToUpdate.get()
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
        if (libroToUpdate.isPresent()) {
            libroToUpdate.get().setStock(libroToUpdate.get().getStock() + stock);
            libroRepository.save(libroToUpdate.get());
            return "Stock actualizado: " + libroToUpdate.get()
                    .getStock() + " unidades";
        }
        return "Stock no actualizado";
    }

    @Override
    public Libro addGenero(Long id, Long idGenero) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var genero = generoRepository.findById(idGenero);
            genero.ifPresent(value -> libroToUpdate
                    .get().getGeneros().add(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro addAutor(Long id, Long idAutor) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var autor = autorRepository.findById(idAutor);
            autor.ifPresent(value -> libroToUpdate
                    .get().getAutores().add(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro addEditorial(Long id, Long idEditorial) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var editorial = editorialRepository.findById(idEditorial);
            editorial.ifPresent(value -> libroToUpdate
                    .get().getEditoriales().add(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro addFormato(Long idLibro, Libro.TipoFormato formato) {
        var libroToUpdate = libroRepository.findById(idLibro);
        if (libroToUpdate.isPresent()) {
            libroToUpdate.get().getFormatos()
                    .add(formato);
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro removeGenero(Long id, Long idGenero) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var genero = generoRepository.findById(idGenero);
            genero.ifPresent(value -> libroToUpdate
                    .get().getGeneros().remove(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro removeAutor(Long id, Long idAutor) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var autor = autorRepository.findById(idAutor);
            autor.ifPresent(value -> libroToUpdate
                    .get().getAutores().remove(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro removeEditorial(Long id, Long idEditorial) {
        var libroToUpdate = libroRepository.findById(id);
        if (libroToUpdate.isPresent()) {
            var editorial = editorialRepository.findById(idEditorial);
            editorial.ifPresent(value -> libroToUpdate
                    .get().getEditoriales().remove(value));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }

    @Override
    public Libro removeFormato(Long idLibro, String formato) {
        var libroToUpdate = libroRepository.findById(idLibro);
        if (libroToUpdate.isPresent()) {
            libroToUpdate.get().getFormatos()
                    .remove(Libro.TipoFormato.valueOf(formato));
            return libroRepository.save(libroToUpdate.get());
        }
        return null;
    }
}
