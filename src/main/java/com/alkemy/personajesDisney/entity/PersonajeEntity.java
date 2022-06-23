package com.alkemy.personajesDisney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "personaje")
@SQLDelete(sql="UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String imagen;
    private Integer edad;
    private Double peso;
    private String historia;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "personajes",cascade = CascadeType.PERSIST)
    private List<PeliculaEntity> peliculas = new ArrayList<>();

    public void addPelicula(PeliculaEntity pelicula) {
        this.peliculas.add(pelicula);
    }

    public void removePelicula(PeliculaEntity pelicula) {
        this.peliculas.remove(pelicula);
    }

}
