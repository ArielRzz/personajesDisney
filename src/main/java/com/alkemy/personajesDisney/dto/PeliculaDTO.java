package com.alkemy.personajesDisney.dto;

import com.alkemy.personajesDisney.entity.GeneroEntity;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private Integer calificacion;
    private GeneroEntity genero;
    private Set<PersonajeDTO> personajes = new HashSet<>();
}
