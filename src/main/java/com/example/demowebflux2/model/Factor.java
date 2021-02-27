package com.example.demowebflux2.model;

import java.time.LocalDate;

public class Factor {
    private LocalDate fecha;
    private Integer dia;
    private double factor;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Factor(LocalDate fecha, Integer dia, double factor) {
        this.fecha = fecha;
        this.dia = dia;
        this.factor = factor;
    }

    public Factor() {
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
