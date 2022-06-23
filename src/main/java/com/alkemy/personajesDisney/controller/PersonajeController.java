package com.alkemy.personajesDisney.controller;

import com.alkemy.personajesDisney.dto.PersonajeDTO;
import com.alkemy.personajesDisney.service.PersonajeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping("/guardar")
    public ResponseEntity<PersonajeDTO> save(@Valid @RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeGuardado = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado) ;
    }

    @GetMapping("/traerTodos")
    public ResponseEntity<Collection<PersonajeDTO>> getAll(){
        Collection<PersonajeDTO> todosLosPersonajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(todosLosPersonajes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public PersonajeDTO getPersonaje(@PathVariable Long id){
        PersonajeDTO personajeTraido = personajeService.get(id);
        return personajeTraido;
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<PersonajeDTO> getDetallePersonaje(@PathVariable Long id) {
    PersonajeDTO personajeTraido = personajeService.getDetalle(id);
        return ResponseEntity.ok().body(personajeTraido);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> actualizarPersonaje(
                            @PathVariable Long id,
                            @RequestBody PersonajeDTO personajeActualizar){
        PersonajeDTO personajeActualizado = personajeService.update(id,personajeActualizar);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeActualizado) ;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetallePorFiltros(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer edad,
            @RequestParam(required = false) Double peso,
            @RequestParam(required = false) List<Long> peliculas,
            @RequestParam(required = false,defaultValue = "ASC")    String order
    ) {
        List<PersonajeDTO> personajesPersonajeDTOS = this.personajeService.getByFilters(nombre,edad,peso,peliculas,order);
        return ResponseEntity.ok(personajesPersonajeDTOS);
    }
}
