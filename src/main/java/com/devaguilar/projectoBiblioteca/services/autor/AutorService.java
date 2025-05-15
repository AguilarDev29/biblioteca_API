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
        return autorRepository.findByApellidoAndNombre(fullName);
    }

    @Override
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public void saveAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(Autor autor, long id) {

        var optionalAutor = autorRepository.findById(id);

        if(optionalAutor.isPresent()) {
            if(autor.getApellido() != null) optionalAutor.get()
                    .setApellido(autor.getApellido());
            if(autor.getNombre() != null) optionalAutor.get()
                    .setNombre(autor.getNombre());
            if(autor.getSexo() != null) optionalAutor.get()
                    .setSexo(autor.getSexo());
            if(autor.getFechaNacimiento() != null) optionalAutor.get()
                    .setFechaNacimiento(autor.getFechaNacimiento());
            if(autor.getFechaDefuncion() != null) optionalAutor.get()
                    .setFechaDefuncion(autor.getFechaDefuncion());
            if(autor.getNacionalidad() != null) optionalAutor.get()
                    .setNacionalidad(autor.getNacionalidad());

            return autorRepository.save(optionalAutor.get());
        }
        return null;
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
