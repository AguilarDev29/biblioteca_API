package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.Autor;
import com.devaguilar.projectoBiblioteca.services.autor.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Autor>> getAllAutor() {
        return ResponseEntity.ok(autorService.getAllAutor());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Autor> getAutorById(Long id) {

        var autor = autorService.getAutorById(id);

        if (autor == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(autorService.getAutorById(id));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAutorByFullName(@RequestParam(name = "fullname" )
                                                              String fullname) {

        var autor = autorService.getAutorByFullName(fullname);

        if (autor == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(autorService.getAutorByFullName(fullname));
    }

    @PostMapping("/create")
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.saveAutor(autor));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> updateAutor(@RequestBody Autor autor,
                                             @PathVariable Long id) {
        return ResponseEntity.ok(autorService.updateAutor(autor, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
