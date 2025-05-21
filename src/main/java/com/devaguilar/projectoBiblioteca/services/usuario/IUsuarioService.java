package com.devaguilar.projectoBiblioteca.services.usuario;

import com.devaguilar.projectoBiblioteca.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Long id);

    Usuario getUsuarioByUsername(String username);

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario, Long id);

    void deleteUsuario(Long id);
}
