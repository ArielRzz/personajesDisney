package com.alkemy.personajesDisney.repository;

import com.alkemy.personajesDisney.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository <PersonajeEntity,Long>{
}
