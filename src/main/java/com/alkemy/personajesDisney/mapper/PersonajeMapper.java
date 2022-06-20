package com.alkemy.personajesDisney.mapper;

import com.alkemy.personajesDisney.dto.PeliculaDTO;
import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonajeMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setPeso(dto.getPeso());

        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity,boolean loadPeliculas){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setEdad(entity.getEdad());
        dto.setNombre(entity.getNombre());
        dto.setPeso(entity.getPeso());
        if (loadPeliculas){
            List<PeliculaDTO> peliculasDTOS = this.peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(),false);
        }

        return dto;
    }

    public Set<PersonajeDTO> personajeEntity2DTOList(Collection<PersonajeEntity> personajeList, boolean loadPeliculas) {
    Set<PersonajeDTO> dtos = new HashSet<>();
        for (PersonajeEntity entity:personajeList) {
            dtos.add(personajeEntity2DTO(entity,loadPeliculas));
        }
        return dtos;
    }

    public Set<PersonajeEntity> personajeDTOList2EntityList(Collection<PersonajeDTO> personajeDTOS){
        Set<PersonajeEntity> entities = new HashSet<>();
        for ( PersonajeDTO dto : personajeDTOS ) {
            entities.add(this.personajeDTO2Entity(dto));
        }
        return entities;
    }



    public void personajeEntityRefreshValues(PersonajeEntity personajeEntity,PersonajeDTO personajeDTO){
        personajeEntity.setNombre(personajeDTO.getNombre());
        personajeEntity.setPeso(personajeDTO.getPeso());
        personajeEntity.setEdad(personajeDTO.getEdad());
        personajeEntity.setHistoria(personajeDTO.getHistoria());
    }
}
