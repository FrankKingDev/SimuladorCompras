package com.example.demowebflux2.business;

import com.example.demowebflux2.model.Persona;
import com.example.demowebflux2.repository.PersonasRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class PersonaSender {
    private PersonasRepository oPersonasRepository;

    public PersonaSender(PersonasRepository oPersonasRepository) {
        this.oPersonasRepository = oPersonasRepository;
    }

    public List<Persona> listarPersonas(){
        List<Persona> all = oPersonasRepository.findAll();
        return all;
    }

    public Persona findById(Integer id){
        var Persona = oPersonasRepository.findById(id).get();
        return Persona;
    }
    public Persona insert(Persona persona){
        return oPersonasRepository.save(persona);
    }
    public void eliminar(Integer id){
        oPersonasRepository.deleteById(id);
    }



}
