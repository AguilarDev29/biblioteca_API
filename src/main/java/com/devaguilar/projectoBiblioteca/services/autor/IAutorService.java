package com.devaguilar.projectoBiblioteca.services.autor;

import com.devaguilar.projectoBiblioteca.models.Autor;
import java.util.List;

public interface IAutorService {

    Autor getAutorById(Long id);

    List<Autor> getAutorByFullName(String fullName);

    List<Autor> getAllAutor();

    Autor saveAutor(Autor autor);

    Autor updateAutor(Autor autor, long id);

    void deleteAutor(Long id);
}
