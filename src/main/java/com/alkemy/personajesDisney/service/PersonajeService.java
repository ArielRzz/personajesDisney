package com.alkemy.personajesDisney.service;

import com.alkemy.personajesDisney.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {
    PersonajeDTO save(PersonajeDTO dto);

    List<PersonajeDTO> getAllPersonajes();
}
