package com.alkemy.personajesDisney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "genero")
public class GeneroEntity {
    @Id
    @Column(name = "idGenero", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String imagen;

    @OneToMany
    private List<PeliculaEntity> peliculas;

}
