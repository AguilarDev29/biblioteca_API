package com.devaguilar.projectoBiblioteca.services.autor;

import com.devaguilar.projectoBiblioteca.models.Autor;
import com.devaguilar.projectoBiblioteca.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutorService implements IAutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Autor> getAutorByFullName(String fullName) {
        return autorRepository.getByFullName(fullName);
    }

    @Override
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(Autor autor, long id) {

        var autorToUpdate = autorRepository.findById(id);

        if(autorToUpdate.isPresent()) {
            if(autor.getApellido() != null) autorToUpdate.get()
                    .setApellido(autor.getApellido());
            if(autor.getNombre() != null) autorToUpdate.get()
                    .setNombre(autor.getNombre());
            if(autor.getSexo() != null) autorToUpdate.get()
                    .setSexo(autor.getSexo());
            if(autor.getFechaNacimiento() != null) autorToUpdate.get()
                    .setFechaNacimiento(autor.getFechaNacimiento());
            if(autor.getFechaDefuncion() != null) autorToUpdate.get()
                    .setFechaDefuncion(autor.getFechaDefuncion());
            if(autor.getNacionalidad() != null) autorToUpdate.get()
                    .setNacionalidad(autor.getNacionalidad());

            return autorRepository.save(autorToUpdate.get());
        }
        return null;
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
