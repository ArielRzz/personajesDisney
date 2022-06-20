package com.alkemy.personajesDisney.service.impl;

import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.entity.PersonajeEntity;
import com.alkemy.personajesDisney.exception.ParamNotFound;
import com.alkemy.personajesDisney.mapper.PersonajeMapper;
import com.alkemy.personajesDisney.repository.PersonajeRepository;
import com.alkemy.personajesDisney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto){
        PersonajeEntity personaje = personajeMapper.personajeDTO2Entity(dto);
        //save devuelve la entidad que se guardò.
        //guardamos la entidad
        PersonajeEntity entidadGuardada = personajeRepository.save(personaje);
        //pasamos la entidad a dto para mandarlo al controller
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entidadGuardada,false);
        System.out.println("Guardar Continente");
        return result;
    }

    @Override
    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeEntity> listaPersonajes = personajeRepository.findAll();
        List<PersonajeDTO> resultList = (List<PersonajeDTO>) personajeMapper.personajeEntity2DTOList(listaPersonajes,false);
        return  resultList;
    }

    @Override
    public void delete(Long id) {
            personajeRepository.deleteById(id);
    }

    @Override
    public PersonajeDTO get(Long id) {
        Optional<PersonajeEntity> encontrado =personajeRepository.findById(id);
        if (!encontrado.isPresent()){
            throw new ParamNotFound("Id del personaje no encontrado");
        }
        PersonajeDTO dto = personajeMapper.personajeEntity2DTO(encontrado.get(),false);
        return dto;
    }

    @Override
    public PersonajeDTO update(Long id,PersonajeDTO personajeDTO) {
        Optional<PersonajeEntity> entity = this.personajeRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id personaje no valido");
        }
        this.personajeMapper.personajeEntityRefreshValues(entity.get(),personajeDTO);
        PersonajeEntity entitySaved = this.personajeRepository.save(entity.get());
        PersonajeDTO result = this.personajeMapper.personajeEntity2DTO(entitySaved,false);
        return result;
    }
}
