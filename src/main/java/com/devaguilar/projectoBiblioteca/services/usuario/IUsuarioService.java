package com.devaguilar.projectoBiblioteca.services.usuario;

import com.devaguilar.projectoBiblioteca.models.Usuario;

public interface IUsuarioService {


    Usuario getUsuarioById(Long id);
    Usuario getUsuarioByUsername(String username);

    void saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario, Long id);

    void deleteUsuario(Long id);
}
