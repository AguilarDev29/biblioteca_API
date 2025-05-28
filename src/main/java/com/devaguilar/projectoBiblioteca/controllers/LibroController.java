package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
import com.devaguilar.projectoBiblioteca.models.libro.dto.DtoLibroCreate;
import com.devaguilar.projectoBiblioteca.models.libro.dto.DtoLibroUpdate;
import com.devaguilar.projectoBiblioteca.services.libro.ILibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    private final ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Libro>> getAllLibros() {
        return ResponseEntity.ok(libroService.getAllLibros());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {

        var libro = libroService.getLibroById(id);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/search/titulo/{titulo}")
    public ResponseEntity<List<Libro>> getLibroByTitulo(@PathVariable String titulo) {
        var libro = libroService.getByTitulo(titulo);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/search/autor/{autor}")
    public ResponseEntity<List<Libro>> getLibroByAutor(@PathVariable String autor) {

        var libro = libroService.getByAutor(autor);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/search/genero/{genero}")
    public ResponseEntity<List<Libro>> getLibroByGenero(@PathVariable String genero) {

        var libro = libroService.getByGenero(genero);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/search/editorial/{editorial}")
    public ResponseEntity<List<Libro>> getLibroByEditorial(@PathVariable String editorial) {

        var libro = libroService.getByEditorial(editorial);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/search/formato/{formato}")
    public ResponseEntity<List<Libro>> getLibroByFormato(@PathVariable Libro.TipoFormato formato) {

        var libro = libroService.getByFormato(formato);
        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libro);
    }

    @PostMapping("/create")
    public ResponseEntity<Libro> saveLibro(@RequestBody DtoLibroCreate libro) {

        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.saveLibro(new Libro(libro)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Libro> updateLibro(@RequestBody DtoLibroUpdate libro,
                                             @PathVariable Long id) {

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.updateLibro(new Libro(libro), id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {


        if(libroService.getLibroById(id) == null) return ResponseEntity.notFound().build();

        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/stock/{id}/{stock}")
    public ResponseEntity<String> updateStock(@PathVariable Long id,
                                              @PathVariable int stock) {

        if(libroService.getLibroById(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.updateStock(id, stock));
    }

    @PutMapping("/update/genero/{id}/{idGenero}")
    public ResponseEntity<Libro> addGenero(@PathVariable Long id, @PathVariable Long idGenero) {

        var libro = libroService.addGenero(id, idGenero);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/update/autor/{id}/{idAutor}")
    public ResponseEntity<Libro> addAutor(@PathVariable Long id, @PathVariable Long idAutor) {

        var libro = libroService.addAutor(id, idAutor);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/update/editorial/{id}/{idEditorial}")
    public ResponseEntity<Libro> addEditorial(@PathVariable Long id, @PathVariable Long idEditorial) {

        var libro = libroService.addEditorial(id, idEditorial);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/update/formato/{idLibro}/{formato}")
    public ResponseEntity<Libro> addFormato(@PathVariable Long idLibro, @PathVariable Libro.TipoFormato formato) {

        var libro = libroService.addFormato(idLibro, formato);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.addFormato(idLibro, formato));
    }

    @PutMapping("/delete/genero/{id}/{idGenero}")
    public ResponseEntity<Libro> removeGenero(@PathVariable Long id, @PathVariable Long idGenero) {

        var libro = libroService.removeGenero(id, idGenero);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.removeGenero(id, idGenero));
    }

    @PutMapping("/delete/autor/{id}/{idAutor}")
    public ResponseEntity<Libro> removeAutor(@PathVariable Long id, @PathVariable Long idAutor) {

        var libro = libroService.removeAutor(id, idAutor);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.removeAutor(id, idAutor));
    }

    @PutMapping("/delete/editorial/{id}/{idEditorial}")
    public ResponseEntity<Libro> removeEditorial(@PathVariable Long id, @PathVariable Long idEditorial) {

        var libro = libroService.removeEditorial(id, idEditorial);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.removeEditorial(id, idEditorial));
    }

    @PutMapping("/delete/formato/{idLibro}/{formato}")
    public ResponseEntity<Libro> removeFormato(@PathVariable Long idLibro, @PathVariable String formato) {

        var libro = libroService.removeFormato(idLibro, formato);
        if(libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.removeFormato(idLibro, formato));
    }
}
