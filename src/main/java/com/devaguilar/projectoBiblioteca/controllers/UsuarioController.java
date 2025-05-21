package com.devaguilar.projectoBiblioteca.controllers;

import com.devaguilar.projectoBiblioteca.models.Usuario;
import com.devaguilar.projectoBiblioteca.services.usuario.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Usuario> getUsuarioById(Long id){
        var usuario = usuarioService.getUsuarioById(id);
        if(usuario == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @GetMapping("/search/")
    public ResponseEntity<Usuario> getUsuarioByUsername(@RequestParam(name = "username") String username){
        return ResponseEntity.ok(usuarioService.getUsuarioByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }
}
