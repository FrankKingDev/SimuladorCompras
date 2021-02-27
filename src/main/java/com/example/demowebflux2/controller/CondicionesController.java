package com.example.demowebflux2.controller;

import com.example.demowebflux2.business.PersonasService;
import com.example.demowebflux2.model.Condiciones;
import com.example.demowebflux2.model.Persona;
import com.example.demowebflux2.repository.CondicionesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/condiciones")
public class CondicionesController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CondicionesRepository CondicionesRepository;

    public CondicionesController(CondicionesRepository CondicionesRepository) {
        this.CondicionesRepository = CondicionesRepository;
    }
    @GetMapping("/listar")
    public Flux<Condiciones> listarCondiciones(){
        List<Condiciones> listaPersonas = this.CondicionesRepository.findAll();
        logger.info("Return Lista de Personas Bootcamp");
        return Flux.fromIterable(listaPersonas);
    }

}
