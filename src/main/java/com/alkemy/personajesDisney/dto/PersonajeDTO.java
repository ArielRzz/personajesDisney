package com.alkemy.personajesDisney.dto;

import com.alkemy.personajesDisney.entity.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonajeDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private double peso;
    private String historia;

    private List<PeliculaDTO> peliculas = new ArrayList<>();
}
