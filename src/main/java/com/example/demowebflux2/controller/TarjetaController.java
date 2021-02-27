package com.example.demowebflux2.controller;

import com.example.demowebflux2.model.Condiciones;
import com.example.demowebflux2.model.Tarjeta;
import com.example.demowebflux2.repository.TarjetasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TarjetasRepository TarjetasRepository;


    public TarjetaController(TarjetasRepository tarjetasRepository) {
        TarjetasRepository = tarjetasRepository;
    }

    @GetMapping("/listar")
    public Flux<Tarjeta> listarCondiciones(){
        List<Tarjeta> listaPersonas = this.TarjetasRepository.findAll();
        logger.info("Return Lista de Personas Bootcamp");
        return Flux.fromIterable(listaPersonas);
    }
}
