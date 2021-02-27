package com.example.demowebflux2.repository;

import com.example.demowebflux2.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetasRepository extends JpaRepository<Tarjeta,Integer> {
}
