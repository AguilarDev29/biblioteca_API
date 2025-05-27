package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import com.devaguilar.projectoBiblioteca.models.genero.dto.DtoGeneroCreateUpdate;
import com.devaguilar.projectoBiblioteca.services.genero.IGeneroService;
import jakarta.validation.Valid;
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

    @GetMapping("/search")
    public ResponseEntity<List<Genero>> getGeneroByLibro(@RequestParam(name = "libro")
                                                             String libro) {
        var genero = generoService.getGeneroByLibro(libro);
        if(genero == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(genero);
    }

    @PostMapping("/create")
    public ResponseEntity<Genero> saveGenero(@RequestBody DtoGeneroCreateUpdate genero) {

        if(genero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(generoService.saveGenero(new Genero(genero)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genero> updateGenero(@RequestBody @Valid DtoGeneroCreateUpdate genero,
                                               @PathVariable Long id) {
        if(generoService.getGeneroById(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(generoService.updateGenero(new Genero(genero), id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {

        if(generoService.getGeneroById(id) == null) return ResponseEntity.notFound().build();
        generoService.deleteGenero(id);
        return ResponseEntity.noContent().build();
    }
}
