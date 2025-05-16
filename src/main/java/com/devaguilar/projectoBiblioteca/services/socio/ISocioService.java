package com.devaguilar.projectoBiblioteca.services.socio;

import com.devaguilar.projectoBiblioteca.models.Socio;

public interface ISocioService {

    Socio getSocioById(long id);

    Socio getSocioByDni(String dni);

    void saveSocio(Socio socio);

    Socio updateSocio(Socio socio, long id);

    void deleteSocio(long id);
}
