package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.Prestamo;
import com.devaguilar.projectoBiblioteca.services.prestamo.IPrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    private final IPrestamoService prestamoService;

    public PrestamoController(IPrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prestamo>> getAllPrestamo(){
        return ResponseEntity.ok(prestamoService.getAllPrestamo());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(Long id){

        var prestamo = prestamoService.getPrestamoById(id);

        if(prestamo == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(prestamoService.getPrestamoById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Prestamo> savePrestamo(@RequestBody Prestamo prestamo){
        return ResponseEntity.ok(prestamoService.savePrestamo(prestamo));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@RequestBody Prestamo prestamo, @PathVariable Long id){
        return ResponseEntity.ok(prestamoService.updatePrestamo(prestamo, id));
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<Void> cancelarPrestamo(@PathVariable Long id){
        prestamoService.cancelarPrestamo(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id){
        prestamoService.deletePrestamo(id);
        return ResponseEntity.ok().build();
    }
}
