package com.example.demowebflux2.model;

import java.time.LocalDate;
import java.util.Date;

public class SimuladorResponse {

    private double cuota;
    private String moneda;
    private LocalDate primeracuota;
    private String estado;

    public SimuladorResponse() {
    }

    public SimuladorResponse(double cuota, String moneda, LocalDate primeracuota, String estado) {
        this.cuota = cuota;
        this.moneda = moneda;
        this.primeracuota = primeracuota;
        this.estado = estado;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDate getPrimeracuota() {
        return primeracuota;
    }

    public void setPrimeracuota(LocalDate primeracuota) {
        this.primeracuota = primeracuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    /*
    {
        "cuota": "100.00",
            "moneda": "S/",
            "primeraCuota":"12/12/2020",
            "estado":"exitoso"
    }
    
     */
}
