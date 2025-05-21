package com.devaguilar.projectoBiblioteca.services.prestamo;

import com.devaguilar.projectoBiblioteca.models.Prestamo;

import java.util.List;

public interface IPrestamoService {

    Prestamo getPrestamoById(long id);

    List<Prestamo> getAllPrestamo();

    Prestamo savePrestamo(Prestamo prestamo);

    Prestamo updatePrestamo(Prestamo prestamo, long id);

    void cancelarPrestamo(long id);

    void deletePrestamo(long id);
}
