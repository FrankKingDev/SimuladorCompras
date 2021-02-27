package com.example.demowebflux2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tarjeta")
public class Tarjeta {

    @Id
    @Column(name = "id", columnDefinition = "")
    private int id;
    @Column
    private String nombre;
    public Tarjeta(){};
    public Tarjeta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
