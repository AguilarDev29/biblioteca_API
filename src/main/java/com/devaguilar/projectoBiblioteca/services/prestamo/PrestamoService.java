package com.devaguilar.projectoBiblioteca.services.prestamo;

import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;
import com.devaguilar.projectoBiblioteca.repositories.LibroRepository;
import com.devaguilar.projectoBiblioteca.repositories.PrestamoRepository;
import com.devaguilar.projectoBiblioteca.repositories.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService{

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final SocioRepository socioRepository;
    public PrestamoService(PrestamoRepository prestamoRepository, LibroRepository libroRepository, SocioRepository socioRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
        this.socioRepository = socioRepository;
    }

    @Override
    public Prestamo getPrestamoById(long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prestamo> getAllPrestamo() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo updatePrestamo(long idLibro, long idSocio, long id) {

        var prestamoToUpdate = prestamoRepository.findById(id);
        var libro = libroRepository.findById(idLibro);
        var socio = socioRepository.findById(idSocio);

        if(prestamoToUpdate.isPresent()){
            libro.ifPresent(value -> prestamoToUpdate.get().setLibro(value));
            socio.ifPresent(value -> prestamoToUpdate.get().setSocio(value));
            return prestamoRepository.save(prestamoToUpdate.get());
        }
        return null;
    }

    @Override
    public String plusDays(long id, int days) {
        var prestamo = prestamoRepository.findById(id);
        if(prestamo.isPresent()){
            prestamo.get().setFechaLimite(prestamo.get().getFechaLimite().plusDays(days));
            prestamoRepository.save(prestamo.get());
            return "Fecha limite actualizada: " + prestamo.get().getFechaLimite();
        }
        return "No se encontro el prestamo";
    }

    @Override
    public String minusDays(long id, int days) {
        var prestamo = prestamoRepository.findById(id);
        if(prestamo.isPresent()){
            prestamo.get().setFechaLimite(prestamo.get().getFechaLimite().minusDays(days));
            prestamoRepository.save(prestamo.get());
            return "Fecha limite actualizada: " + prestamo.get().getFechaLimite();
        }
        return "No se encontro el prestamo";
    }

    @Override
    public void cancelarPrestamo(long id) {
        var prestamo = prestamoRepository.findById(id);
        if(prestamo.isPresent()){
            prestamo.get().setEstado(Prestamo.EstadoPrestamo.DEVUELTO);
            prestamoRepository.save(prestamo.get());
        }
    }

    @Override
    public void deletePrestamo(long id) {
        prestamoRepository.deleteById(id);
    }

}
