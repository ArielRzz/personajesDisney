package com.alkemy.personajesDisney.dto;
import com.alkemy.personajesDisney.entity.GeneroEntity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
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
    private Long genero_id;
    private Set<PersonajeDTO> personajes = new HashSet<>();
}
