package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.libro.Libro;
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
    public ResponseEntity<Libro> getLibroById(Long id) {

        var libro = libroService.getLibroById(id);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getLibroById(id));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Libro>> getLibroByTitulo(@RequestParam(name = "titulo")
                                                            String titulo) {
        var libro = libroService.getByTitulo(titulo);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getByTitulo(titulo));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Libro>> getLibroByAutor(@RequestParam(name = "autor")
                                                           String autor) {

        var libro = libroService.getByAutor(autor);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getByAutor(autor));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Libro>> getLibroByGenero(@RequestParam(name = "genero")
                                                            String genero) {

        var libro = libroService.getByGenero(genero);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getByGenero(genero));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Libro>> getLibroByEditorial(@RequestParam(name = "editorial")
                                                               String editorial) {

        var libro = libroService.getByEditorial(editorial);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getByEditorial(editorial));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Libro>> getLibroByFormato(@RequestParam(name = "formato")
                                                             String formato) {

        var libro = libroService.getByFormato(formato);

        if(libro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(libroService.getByFormato(formato));
    }

    @PostMapping("/create")
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.saveLibro(libro));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro,
                                             @PathVariable Long id) {
        return ResponseEntity.ok(libroService.updateLibro(libro));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateStock/{id}/{stock}")
    public ResponseEntity<String> updateStock(@PathVariable Long id,
                                              @PathVariable int stock) {
        return ResponseEntity.ok(libroService.updateStock(id, stock));
    }
}
