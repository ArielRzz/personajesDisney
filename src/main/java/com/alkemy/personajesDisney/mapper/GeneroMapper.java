package com.alkemy.personajesDisney.mapper;

import com.alkemy.personajesDisney.dto.GeneroDTO;
import com.alkemy.personajesDisney.dto.PeliculaDTO;
import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.GeneroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class GeneroMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    public GeneroEntity generoDTO2Entity(GeneroDTO dto) {
        GeneroEntity entity = new GeneroEntity();
        entity.setNombre(dto.getNombre());
        entity.setImagen(dto.getImagen());

        return entity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity, boolean loadPeliculas) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        if (loadPeliculas){
            List<PeliculaDTO> peliculasDTO= this.peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(),false);
            dto.setPeliculas(peliculasDTO);
        }
        return dto;
    }
}
