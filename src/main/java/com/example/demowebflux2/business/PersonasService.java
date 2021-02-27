package com.example.demowebflux2.business;

import com.example.demowebflux2.model.Persona;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PersonasService {
    List<Persona> getList();

    Persona findById(Integer id);

    Persona insertar(Persona persona);

    void eliminar(Integer id);
}
