package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.Editorial;
import com.devaguilar.projectoBiblioteca.services.editorial.IEditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editorial")
public class EditorialController {

    private final IEditorialService editorialService;

    public EditorialController(IEditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Editorial>> getAllEditorial() {
        return ResponseEntity.ok(editorialService.getAllEditorial());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Editorial> getEditorialById(Long id) {

        var editorial = editorialService.getEditorialById(id);
        if(editorial == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(editorialService.getEditorialById(id));
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Editorial>> getEditorialByNombre(@RequestParam(name = "nombre")
                                                                    String nombre) {

        var editorial = editorialService.getEditorialByNombre(nombre);

        if(editorial == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(editorialService.getEditorialByNombre(nombre));
    }

    @PostMapping("/create")
    public ResponseEntity<Editorial> saveEditorial(@RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.saveEditorial(editorial));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editorial> updateEditorial(@RequestBody Editorial editorial,
                                                     @PathVariable Long id) {
        return ResponseEntity.ok(editorialService.updateEditorial(editorial, id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEditorial(@PathVariable Long id) {
        editorialService.deleteEditorial(id);
    }
}
