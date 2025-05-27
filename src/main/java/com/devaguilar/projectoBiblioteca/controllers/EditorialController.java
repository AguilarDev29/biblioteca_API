package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.editorial.Editorial;
import com.devaguilar.projectoBiblioteca.models.editorial.dto.DtoEditorialCreateUpdate;
import com.devaguilar.projectoBiblioteca.services.editorial.IEditorialService;
import jakarta.validation.Valid;
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

        return ResponseEntity.ok(editorial);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Editorial>> getEditorialByNombre(@RequestParam(name = "nombre")
                                                                    String nombre) {

        var editorial = editorialService.getEditorialByNombre(nombre);
        if(editorial == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(editorial);
    }

    @PostMapping("/create")
    public ResponseEntity<Editorial> saveEditorial(@RequestBody @Valid DtoEditorialCreateUpdate editorial) {

        if(editorial == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(editorialService.saveEditorial(new Editorial(editorial)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editorial> updateEditorial(@RequestBody @Valid DtoEditorialCreateUpdate editorial,
                                                     @PathVariable Long id) {
        if(editorial == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(editorialService.updateEditorial(new Editorial(editorial), id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEditorial(@PathVariable Long id) {

        if(editorialService.getEditorialById(id) == null) return ResponseEntity.notFound().build();

        editorialService.deleteEditorial(id);
        return ResponseEntity.noContent().build();
    }
}
