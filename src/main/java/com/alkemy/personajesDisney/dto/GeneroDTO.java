package com.alkemy.personajesDisney.dto;

import com.alkemy.personajesDisney.entity.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class GeneroDTO {
    private Long id;
    private String nombre;
    private String imagen;
    private List<PeliculaDTO> peliculas;
}
