package com.alkemy.personajesDisney.repository.specifications;

import com.alkemy.personajesDisney.dto.PersonajeFiltersDTO;
import com.alkemy.personajesDisney.entity.PeliculaEntity;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeEspecification {

    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder)->{
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getNombre())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }


           if(!CollectionUtils.isEmpty(filtersDTO.getPeliculas())){
                Join<PeliculaEntity, PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculas_id = join.get("id");
                predicates.add(peliculas_id.in(filtersDTO.getPeliculas()));
            }
           if (filtersDTO.getEdad() instanceof Integer && filtersDTO.getEdad()>0){
               predicates.add(
                       criteriaBuilder.equal(root.get("edad"),filtersDTO.getEdad())
               );
           }

            //Remove duplicates
            query.distinct(true);

            //Order resolver
            String orderByField = "nombre";
            query.orderBy(
                    filtersDTO.isASC()?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}