package com.alkemy.personajesDisney.dto;

import com.alkemy.personajesDisney.entity.GeneroEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PeliculaBasicDTO {

    private Long id;
    private String titulo;
    private Long genero_id;
}
