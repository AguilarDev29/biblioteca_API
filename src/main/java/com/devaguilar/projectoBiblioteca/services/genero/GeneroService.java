package com.devaguilar.projectoBiblioteca.services.genero;

import com.devaguilar.projectoBiblioteca.models.Genero;
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
    public void saveGenero(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    public Genero updateGenero(Genero genero) {
        var optionalGenero = generoRepository.findByNombre(genero.getNombre());
        if(optionalGenero.isPresent()) {
            if(genero.getNombre() != null) optionalGenero.get()
                    .setNombre(genero.getNombre());

            return generoRepository.save(optionalGenero.get());
        }
        return null;
    }

    @Override
    public void deleteGeneroByNombre(String nombre) {
        var genero = generoRepository.findByNombre(nombre);
        genero.ifPresent(generoRepository::delete);
    }
}
