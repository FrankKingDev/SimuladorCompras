package com.example.demowebflux2.model;

import javax.persistence.*;

@Entity
@Table(name="Condiciones")
public class Condiciones {
    @Id
    @Column(name = "id", columnDefinition = "")
    private int id;

    @ManyToOne
    private Tarjeta tarjeta;
    public Condiciones(){}
    public Condiciones(int id, Tarjeta tarjeta, Integer cuotamin, Integer cuotamax, Double tea, Integer diapago) {
        this.id = id;
        this.tarjeta = tarjeta;
        this.cuotamin = cuotamin;
        this.cuotamax = cuotamax;
        this.tea = tea;
        this.diapago = diapago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Integer getCuotamin() {
        return cuotamin;
    }

    public void setCuotamin(Integer cuotamin) {
        this.cuotamin = cuotamin;
    }

    public Integer getCuotamax() {
        return cuotamax;
    }

    public void setCuotamax(Integer cuotamax) {
        this.cuotamax = cuotamax;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public Integer getDiapago() {
        return diapago;
    }

    public void setDiapago(Integer diapago) {
        this.diapago = diapago;
    }

    @Column
    private Integer cuotamin;

    @Column
    private Integer cuotamax;

    @Column
    private Double tea;

    @Column
    private Integer diapago;
}
