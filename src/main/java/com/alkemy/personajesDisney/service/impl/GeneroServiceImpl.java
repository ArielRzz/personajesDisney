package com.alkemy.personajesDisney.service.impl;

import com.alkemy.personajesDisney.dto.GeneroDTO;
import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.GeneroEntity;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import com.alkemy.personajesDisney.mapper.GeneroMapper;
import com.alkemy.personajesDisney.mapper.PersonajeMapper;
import com.alkemy.personajesDisney.repository.GeneroRepository;
import com.alkemy.personajesDisney.repository.PersonajeRepository;
import com.alkemy.personajesDisney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;


    @Override
    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity genero = generoMapper.generoDTO2Entity(dto);
        GeneroEntity generoGuardado = generoRepository.save(genero);
        GeneroDTO result = generoMapper.generoEntity2DTO(generoGuardado,false);
        System.out.println("Guardar Genero");
        return result;
    }
}
