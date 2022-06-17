package com.alkemy.personajesDisney.service.impl;

import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.service.PersonajeService;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    public PersonajeDTO save(PersonajeDTO dto){
        //TODO: guardar continente
        //1 pasarlo a entidad

        System.out.println("Guardar Continente");
        return dto;
    }
}
