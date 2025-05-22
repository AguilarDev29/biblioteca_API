package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import com.devaguilar.projectoBiblioteca.services.genero.IGeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    private final IGeneroService generoService;

    public GeneroController(IGeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Genero>> getAllGenero() {
        return ResponseEntity.ok(generoService.getAllGenero());
    }

    @GetMapping("/seach/")
    public ResponseEntity<List<Genero>> getGeneroByLibro(@RequestParam(name = "libro")
                                                             String libro) {
        var genero = generoService.getGeneroByLibro(libro);

        if(genero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(generoService.getGeneroByLibro(libro));
    }

    @PostMapping("/create")
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok(generoService.saveGenero(genero));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genero> updateGenero(@RequestBody Genero genero,
                                               @PathVariable Long id) {
        return ResponseEntity.ok(generoService.updateGenero(genero));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        generoService.deleteGeneroByNombre(id.toString());
        return ResponseEntity.noContent().build();
    }
}
