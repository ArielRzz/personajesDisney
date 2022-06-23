package com.alkemy.personajesDisney.entity;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pelicula")
public class PeliculaEntity {
    @Id
    @Column(name = "idPelicula", nullable = false)
    private Long id;
    private String imagen;
    @NotNull
    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    @ManyToOne()
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaEntity that = (PeliculaEntity) o;
        return Objects.equals(imagen, that.imagen) && Objects.equals(titulo, that.titulo) && Objects.equals(fechaCreacion, that.fechaCreacion) && Objects.equals(personajes, that.personajes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagen, titulo, fechaCreacion, personajes);
    }
}
