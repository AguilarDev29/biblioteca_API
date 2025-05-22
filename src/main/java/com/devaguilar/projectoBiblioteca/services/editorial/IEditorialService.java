package com.devaguilar.projectoBiblioteca.services.editorial;

import com.devaguilar.projectoBiblioteca.models.editorial.Editorial;
import java.util.List;
public interface IEditorialService {

    Editorial getEditorialById(Long id);

    List<Editorial> getEditorialByNombre(String nombre);

    List<Editorial> getAllEditorial();

    Editorial saveEditorial(Editorial editorial);

    Editorial updateEditorial(Editorial editorial, long id);

    void deleteEditorial(Long id);
}
