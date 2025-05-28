package com.devaguilar.projectoBiblioteca.services.prestamo;

import com.devaguilar.projectoBiblioteca.models.prestamo.Prestamo;

import java.util.List;

public interface IPrestamoService {

    Prestamo getPrestamoById(long id);

    List<Prestamo> getAllPrestamo();

    Prestamo savePrestamo(Prestamo prestamo);

    Prestamo updatePrestamo(long idLibro, long idSocio, long id);

    String plusDays(long id,int days);

    String minusDays(long id, int days);

    void cancelarPrestamo(long id);

    void deletePrestamo(long id);
}
