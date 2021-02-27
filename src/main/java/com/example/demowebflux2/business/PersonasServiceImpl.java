package com.example.demowebflux2.business;

import com.example.demowebflux2.model.Persona;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PersonasServiceImpl implements PersonasService{
    final private PersonaSender PersonaSender;

    public PersonasServiceImpl(PersonaSender sender) {
        this.PersonaSender=sender;
    }

    @Override
    public List<Persona> getList() {
        return  PersonaSender.listarPersonas();
    }

    @Override
    public Persona findById(Integer id) {
        return  PersonaSender.findById(id);
    }

    @Override
    public Persona insertar(Persona persona) {
        return PersonaSender.insert(persona);
    }
    @Override
    public void eliminar(Integer id){
        PersonaSender.eliminar(id);
    }
}
