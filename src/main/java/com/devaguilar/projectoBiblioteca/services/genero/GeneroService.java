package com.devaguilar.projectoBiblioteca.services.genero;

import com.devaguilar.projectoBiblioteca.models.genero.Genero;
import com.devaguilar.projectoBiblioteca.repositories.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Genero> getAllGenero() {
        return generoRepository.findAll();
    }

    @Override
    public Genero getGeneroById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genero> getGeneroByLibro(String libro) {
        return generoRepository.findByLibrosTitulo(libro);
    }

    @Override
    public Genero saveGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero updateGenero(Genero genero, Long id) {
        var generoToUpdate = generoRepository.findById(id);
        if(generoToUpdate.isPresent()) {
            if(genero.getNombre() != null) generoToUpdate.get()
                    .setNombre(genero.getNombre());

            return generoRepository.save(generoToUpdate.get());
        }
        return null;
    }

    @Override
    public void deleteGenero(Long id) {
        var genero = generoRepository.findById(id);
        genero.ifPresent(generoRepository::delete);
    }


}
