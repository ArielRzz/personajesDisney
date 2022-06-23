package com.alkemy.personajesDisney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonajeFiltersDTO {
    private String nombre;
    private Integer edad;
    private Double peso;
    private List<Long> peliculas;
    private String order;

    public PersonajeFiltersDTO(String nombre, Integer edad, Double peso, List<Long> peliculas, String order) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.peliculas = peliculas;
        this.order = order;
    }

    public boolean isASC(){ return this.order.compareToIgnoreCase("ASC")==0; }

    public boolean isDESC(){ return this.order.compareToIgnoreCase("DESC")==0; }

}
