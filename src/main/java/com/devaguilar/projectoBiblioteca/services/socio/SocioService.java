package com.devaguilar.projectoBiblioteca.services.socio;

import com.devaguilar.projectoBiblioteca.models.socio.Socio;
import com.devaguilar.projectoBiblioteca.repositories.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioService implements ISocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @Override
    public List<Socio> getAllSocio() {
        return socioRepository.findAll();
    }

    @Override
    public Socio getSocioById(long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @Override
    public Socio getSocioByDni(String dni) {
        return socioRepository.findByDni(dni).orElse(null);
    }

    @Override
    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public Socio updateSocio(Socio socio, long id) {
        var socioToUpdate = socioRepository.findById(id);
        if(socioToUpdate.isPresent()) {
            if(socio.getApellido() != null) socioToUpdate.get()
                    .setApellido(socio.getApellido());
            if(socio.getNombre() != null) socioToUpdate.get()
                    .setNombre(socio.getNombre());
            if(socio.getDni() != null) socioToUpdate.get()
                    .setDni(socio.getDni());
            if(socio.getFechaNacimiento() != null) socioToUpdate.get()
                    .setFechaNacimiento(socio.getFechaNacimiento());
            if(socio.getEmail() != null) socioToUpdate.get()
                    .setEmail(socio.getEmail());
            if(socio.getTelefono() != null) socioToUpdate.get()
                    .setTelefono(socio.getTelefono());

            return socioRepository.save(socioToUpdate.get());
        }
        return null;
    }

    @Override
    public void deleteSocio(long id) {
        socioRepository.deleteById(id);
    }
}
