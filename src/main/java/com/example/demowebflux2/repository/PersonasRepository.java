package com.example.demowebflux2.repository;

import com.example.demowebflux2.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Persona,Integer> {
}
