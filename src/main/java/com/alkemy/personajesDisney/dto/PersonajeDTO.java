package com.alkemy.personajesDisney.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class PersonajeDTO {

    private Long id;
    private String imagen;
    @NotBlank(message = "El nombre no puede ser un espacio en blanco")
    @NotNull(message = "nombre no puede ser null")
    @NotEmpty(message = "no debe de estar vacio el nombre")
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;

    private List<?> peliculas = new ArrayList<>();

    public void setPeliculas(List<?> peliculas) {
        this.peliculas = peliculas;
    }


}
