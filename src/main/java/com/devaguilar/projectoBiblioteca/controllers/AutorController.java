package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.autor.Autor;
import com.devaguilar.projectoBiblioteca.models.autor.dto.DtoAutorCreateUpdate;
import com.devaguilar.projectoBiblioteca.services.autor.IAutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search/")
    public ResponseEntity<List<Autor>> getAutorByFullName(@RequestParam(name = "fullname" )
                                                              String fullname) {

        var autor = autorService.getAutorByFullName(fullname);

        if (autor == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(autorService.getAutorByFullName(fullname));
    }

    @PostMapping("/create")
    public ResponseEntity<Autor> saveAutor(@RequestBody @Valid DtoAutorCreateUpdate autor) {
        if(autor == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(autorService.saveAutor(new Autor(autor)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> updateAutor(@RequestBody @Valid DtoAutorCreateUpdate autor,
                                             @PathVariable Long id) {
        if(autor == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(autorService.updateAutor(new Autor(autor), id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {

        if(autorService.getAutorById(id) == null)
            return ResponseEntity.notFound().build();

        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
