package com.devaguilar.projectoBiblioteca.services.socio;

import com.devaguilar.projectoBiblioteca.models.Socio;

import java.util.List;

public interface ISocioService {

    List<Socio> getAllSocio();

    Socio getSocioById(long id);

    Socio getSocioByDni(String dni);

    Socio saveSocio(Socio socio);

    Socio updateSocio(Socio socio, long id);

    void deleteSocio(long id);
}
