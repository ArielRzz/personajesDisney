package com.alkemy.personajesDisney.mapper;

import com.alkemy.personajesDisney.dto.PeliculaBasicDTO;
import com.alkemy.personajesDisney.dto.PeliculaDTO;
import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.GeneroEntity;
import com.alkemy.personajesDisney.entity.PeliculaEntity;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {
    @Autowired
    PersonajeMapper personajeMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGenero(dto.getGenero());
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity,boolean loadPersonajes){
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(entity.getId());
        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaCreacion(entity.getFechaCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGenero_id(entity.getGenero().getId());
        if (loadPersonajes){
            Set<PersonajeDTO> personajesDTO = this.personajeMapper.personajeEntitySet2SetDTO(entity.getPersonajes(),false);
            peliculaDTO.setPersonajes(personajesDTO);
        }
        return peliculaDTO;
    }
    public PeliculaBasicDTO peliculaBasicEntity2DTO(PeliculaEntity entity){
        PeliculaBasicDTO peliculaBasicDTO = new PeliculaBasicDTO();
        peliculaBasicDTO.setId(entity.getId());
        peliculaBasicDTO.setTitulo(entity.getTitulo());
        peliculaBasicDTO.setGenero_id(entity.getGenero().getId());
        return peliculaBasicDTO;
    }

    public List<PeliculaBasicDTO> peliculaBasicEntityList2DTOList(Collection<PeliculaEntity> peliculas) {
        List<PeliculaBasicDTO> peliculaBasicDTOS = new ArrayList<>();
        for (PeliculaEntity entity: peliculas) {
            peliculaBasicDTOS.add(peliculaBasicEntity2DTO(entity));
        }
        return peliculaBasicDTOS;
    }

    public List<PeliculaDTO> peliculaEntityList2DTOList(Collection<PeliculaEntity> peliculas, boolean loadPersonajes) {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        for (PeliculaEntity entity: peliculas) {
            peliculaDTOS.add(peliculaEntity2DTO(entity,loadPersonajes));
        }
        return peliculaDTOS;
    }


    public LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    public void peliculaEntityRefreshValues(PeliculaEntity peliculaEntity,PeliculaDTO peliculaDTO){
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setGenero(peliculaDTO.getGenero());
        peliculaEntity.setFechaCreacion(peliculaDTO.getFechaCreacion());

    }

}
