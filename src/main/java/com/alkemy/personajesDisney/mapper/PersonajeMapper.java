package com.alkemy.personajesDisney.mapper;

import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setPeso(dto.getPeso());

        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity){
        PersonajeDTO dto = new PersonajeDTO();

        dto.setId(entity.getId());
        dto.setEdad(entity.getEdad());
        dto.setNombre(entity.getNombre());
        dto.setPeso(entity.getPeso());

        return dto;
    }

    public List<PersonajeDTO> personajeEntity2DTOList(List<PersonajeEntity> personajeList) {
    List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity:personajeList) {
            dtos.add(personajeEntity2DTO(entity));
        }
        return dtos;
    }
}
