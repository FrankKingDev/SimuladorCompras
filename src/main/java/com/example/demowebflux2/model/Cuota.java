package com.example.demowebflux2.model;

import java.util.Date;

public class Cuota {
    Integer numcuo;
    double mtocuo;
    String moneda;
    Date fecpago;

    public Integer getNumcuo() {
        return numcuo;
    }

    public void setNumcuo(Integer numcuo) {
        this.numcuo = numcuo;
    }

    public double getMtocuo() {
        return mtocuo;
    }

    public void setMtocuo(double mtocuo) {
        this.mtocuo = mtocuo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFecpago() {
        return fecpago;
    }

    public void setFecpago(Date fecpago) {
        this.fecpago = fecpago;
    }
}
