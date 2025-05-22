package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.socio.Socio;
import com.devaguilar.projectoBiblioteca.services.socio.ISocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socio")
public class SocioController {

    private final ISocioService socioService;

    public SocioController(ISocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Socio>> getAllSocio(){
        return ResponseEntity.ok(socioService.getAllSocio());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Socio> getSocioById(Long id){
        var socio = socioService.getSocioById(id);

        if(socio == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(socio);
    }

    @GetMapping("/search/")
    public ResponseEntity<Socio> getSocioByDni(String dni){
        var socio = socioService.getSocioByDni(dni);

        if(socio == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(socioService.getSocioByDni(dni));
    }

    @PostMapping("/create")
    public ResponseEntity<Socio> saveSocio(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.saveSocio(socio));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Socio> updateSocio(@RequestBody Socio socio,
                                             @PathVariable Long id) {
        return ResponseEntity.ok(socioService.updateSocio(socio, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSocio(@PathVariable Long id) {
        socioService.deleteSocio(id);
        return ResponseEntity.ok().build();
    }
}
