package com.devaguilar.projectoBiblioteca.services.editorial;

import com.devaguilar.projectoBiblioteca.models.Editorial;
import com.devaguilar.projectoBiblioteca.repositories.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService implements IEditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @Override
    public Editorial getEditorialById(Long id) {
        return editorialRepository.findById(id).orElse(null);
    }

    @Override
    public List<Editorial> getEditorialByNombre(String nombre) {
        return editorialRepository.findByNombre(nombre);
    }

    @Override
    public List<Editorial> getAllEditorial() {
        return editorialRepository.findAll();
    }

    @Override
    public void saveEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    @Override
    public Editorial updateEditorial(Editorial editorial, long id) {

        var optionalEditorial = editorialRepository.findById(id);
        if(optionalEditorial.isPresent()) {
            if(editorial.getNombre() != null) optionalEditorial.get()
                    .setNombre(editorial.getNombre());
            return editorialRepository.save(optionalEditorial.get());
        }
        return null;
    }

    @Override
    public void deleteEditorial(Long id) {
        editorialRepository.deleteById(id);
    }
}
