package com.example.demowebflux2.controller;

import com.example.demowebflux2.business.PersonasService;
import com.example.demowebflux2.model.Persona;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PersonasService PersonaService;

    public PersonaController(PersonasService PersonaService) {
        this.PersonaService = PersonaService;
    }

    @GetMapping("/{id}")
    public Mono<Persona> mostrarPersona(@PathVariable Integer id){
        logger.info("Return Person Bootcamp");

        return Mono.just(this.PersonaService.findById(id));
    }

    @GetMapping("/listar")
    public Flux<Persona> listarPersonas(){

        //return Persons

        List<Persona> listaPersonas = this.PersonaService.getList();
        /*List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(1,"Bootcamp1"));
        listaPersonas.add(new Persona(2,"Bootcamp2"));
        listaPersonas.add(new Persona(3,"Bootcamp3"));
        */
        logger.info("Return Lista de Personas Bootcamp");
        return Flux.fromIterable(listaPersonas);
    }

    /*@DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminarPersona(@PathVariable Integer id){
        return buscar(id).
                flatMap( p -> {
                    return eliminar(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
                }).
                defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
     */

    public Mono<Persona> buscar(Integer id){

        logger.info("Buscando Personas con ID: {0}",id.toString());
        if(id == 1){
            logger.info("Encontramos persona");
            return Mono.just(new Persona(1,"Bootcamp"));
        } else {
            logger.info("No se encontró persona");
            return Mono.empty();
        }
    }

    public Mono<Void> eliminar(Persona persona){

        logger.info("Eliminando Persona");
        return Mono.empty();
    }
    @PostMapping("/")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.PersonaService.insertar(persona));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.PersonaService.eliminar(id);
    }

}