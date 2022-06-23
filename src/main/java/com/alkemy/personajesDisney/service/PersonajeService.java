package com.alkemy.personajesDisney.service;

import com.alkemy.personajesDisney.dto.PersonajeDTO;

import java.util.Collection;
import java.util.List;

public interface PersonajeService {
    PersonajeDTO save(PersonajeDTO dto);

    List<PersonajeDTO> getAllPersonajes();

    void delete(Long id);

    PersonajeDTO get(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personajeActualizar);

    PersonajeDTO getDetalle(Long id);

    List<PersonajeDTO> getByFilters(String nombre, Integer edad, Double peso, List<Long> peliculas, String order);
}
