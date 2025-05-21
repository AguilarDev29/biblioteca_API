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
    public List<Genero> getGeneroByLibro(String libro) {
        return generoRepository.findByLibrosTitulo(libro);
    }

    @Override
    public Genero saveGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero updateGenero(Genero genero) {
        var generoToUpdate = generoRepository.findByNombre(genero.getNombre());
        if(generoToUpdate.isPresent()) {
            if(genero.getNombre() != null) generoToUpdate.get()
                    .setNombre(genero.getNombre());

            return generoRepository.save(generoToUpdate.get());
        }
        return null;
    }

    @Override
    public void deleteGeneroByNombre(String nombre) {
        var genero = generoRepository.findByNombre(nombre);
        genero.ifPresent(generoRepository::delete);
    }
}
