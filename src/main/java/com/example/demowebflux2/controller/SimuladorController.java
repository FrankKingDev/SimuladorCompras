package com.example.demowebflux2.controller;

import com.example.demowebflux2.business.PersonasService;
import com.example.demowebflux2.business.SimuladorServiceImpl;
import com.example.demowebflux2.model.Condiciones;
import com.example.demowebflux2.model.Persona;
import com.example.demowebflux2.model.SimuladorRequest;
import com.example.demowebflux2.model.SimuladorResponse;
import com.example.demowebflux2.repository.CondicionesRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/simuladorCompra")
public class SimuladorController {
    @Autowired
    private SimuladorServiceImpl SimuladorServiceImpl;

    @PostMapping(value="/obtenerCuotaMensual", consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimuladorResponse> save(@Valid @RequestBody SimuladorRequest solicitud)
            throws Exception{

        SimuladorResponse respuesta= SimuladorServiceImpl.obtenerCuota(solicitud);
        if(respuesta.getEstado().equals("EXITO")){ return ResponseEntity.status(HttpStatus.CREATED)
                    .body(respuesta);
        }else{
            throw new Exception();
        }
        

    }


}

