package com.devaguilar.projectoBiblioteca.services.usuario;

import com.devaguilar.projectoBiblioteca.models.Usuario;
import com.devaguilar.projectoBiblioteca.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario getUsuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario, Long id) {
        var usuarioToUpdate = usuarioRepository.findById(id).orElse(null);
        if(usuarioToUpdate != null) {
            if (usuario.getUsername() != null) usuarioToUpdate.setUsername(usuario.getUsername());
            if (usuario.getPassword() != null) usuarioToUpdate.setPassword(usuario.getPassword());
            if (usuario.getRole() != null) usuarioToUpdate.setRole(usuario.getRole());

            return usuarioRepository.save(usuarioToUpdate);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
