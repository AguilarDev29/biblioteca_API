package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;
import com.devaguilar.projectoBiblioteca.models.prestamo.dto.DtoPrestamoUpdate;
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
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id){

        var prestamo = prestamoService.getPrestamoById(id);

        if(prestamo == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(prestamo);
    }

    @PostMapping("/create")
    public ResponseEntity<Prestamo> savePrestamo(@RequestBody Prestamo prestamo){

        if(prestamo == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(prestamoService.savePrestamo(prestamo));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@RequestBody DtoPrestamoUpdate prestamo, @PathVariable Long id){

        if(prestamoService.getPrestamoById(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(prestamoService.updatePrestamo(new Prestamo(prestamo), id));
    }

    @PutMapping("/update/plus/{id}/{days}")
    public ResponseEntity<String> plusDays(@PathVariable Long id, @PathVariable int days){

        if(prestamoService.getPrestamoById(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(prestamoService.plusDays(id, days));
    }

    @PutMapping("/update/minus/{id}/{days}")
    public ResponseEntity<String> minusDays(@PathVariable Long id, @PathVariable int days){

        if(prestamoService.getPrestamoById(id) == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(prestamoService.minusDays(id, days));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelarPrestamo(@PathVariable Long id){

        if(prestamoService.getPrestamoById(id) == null) return ResponseEntity.notFound().build();

        prestamoService.cancelarPrestamo(id);
        return ResponseEntity.ok("Prestamo cancelado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id){

        if(prestamoService.getPrestamoById(id) == null) return ResponseEntity.notFound().build();

        prestamoService.deletePrestamo(id);
        return ResponseEntity.ok().build();
    }
}
