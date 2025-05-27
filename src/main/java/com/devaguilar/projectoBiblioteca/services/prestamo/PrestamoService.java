package com.devaguilar.projectoBiblioteca.services.prestamo;

import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;
import com.devaguilar.projectoBiblioteca.repositories.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService{

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
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
    public Prestamo updatePrestamo(Prestamo prestamo, long id) {
        var prestamoToUpdate = prestamoRepository.findById(id);
        if(prestamoToUpdate.isPresent()){
            if(prestamoToUpdate.get().getLibro() != null) prestamoToUpdate.get()
                    .setLibro(prestamo.getLibro());
            if(prestamoToUpdate.get().getSocio() != null) prestamoToUpdate.get()
                    .setSocio(prestamo.getSocio());
            return prestamoRepository.save(prestamoToUpdate.get());
        }
        return null;
    }

    @Override
    public String plusDays(Long id, int days) {
        var prestamo = prestamoRepository.findById(id);
        if(prestamo.isPresent()){
            prestamo.get().setFechaLimite(prestamo.get().getFechaLimite().plusDays(days));
            prestamoRepository.save(prestamo.get());
            return "Fecha limite actualizada: " + prestamo.get().getFechaLimite();
        }
        return "No se encontro el prestamo";
    }

    @Override
    public String minusDays(Long id, int days) {
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
