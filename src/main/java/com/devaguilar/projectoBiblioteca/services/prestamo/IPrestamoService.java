package com.devaguilar.projectoBiblioteca.services.prestamo;

import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;

import java.util.List;

public interface IPrestamoService {

    Prestamo getPrestamoById(long id);

    List<Prestamo> getAllPrestamo();

    Prestamo savePrestamo(Prestamo prestamo);

    Prestamo updatePrestamo(Prestamo prestamo, long id);

    String plusDays(Long id,int days);

    String minusDays(Long id, int days);

    void cancelarPrestamo(long id);

    void deletePrestamo(long id);
}
