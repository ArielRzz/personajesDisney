package com.alkemy.personajesDisney.service.impl;

import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import com.alkemy.personajesDisney.mapper.PersonajeMapper;
import com.alkemy.personajesDisney.repository.PersonajeRepository;
import com.alkemy.personajesDisney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto){
        PersonajeEntity personaje = personajeMapper.personajeDTO2Entity(dto);
        //save devuelve la entidad que se guardò.
        //guardamos la entidad
        PersonajeEntity entidadGuardada = personajeRepository.save(personaje);
        //pasamos la entidad a dto para mandarlo al controller
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entidadGuardada);
        System.out.println("Guardar Continente");
        return result;
    }

    @Override
    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeEntity> listaPersonajes = personajeRepository.findAll();
        List<PersonajeDTO> resultList = personajeMapper.personajeEntity2DTOList(listaPersonajes);
        return  resultList;
    }

    @Override
    public void delete(Long id) {
            personajeRepository.deleteById(id);
    }
}
