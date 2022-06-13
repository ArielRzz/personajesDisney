package com.alkemy.personajesDisney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@Table(name = "genero")
public class GeneroEntity {
    @Id
    @Column(name = "idGenero", nullable = false)
    private Long id;
    private String nombre;
    private String imagen;

}
