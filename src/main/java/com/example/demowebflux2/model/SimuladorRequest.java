package com.example.demowebflux2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimuladorRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @DecimalMin(value="1.0")
    private double monto;

    @NotNull
    @NotEmpty
    @Size(min=8, max = 8)
    private String dni;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(CLASICA|ORO|BLACK){1}$", message = "Los valores permitidos son CLASICA, ORO Y BLACK")
    private String tarjeta;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(S/){1}$", message = "Los valores permitidos son S/")
    private String moneda;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(99.90%|95.90%|90.90%){1}$", message = "las tasas solo pueden ser 99.90%,95.90%,90.90%")
    private String tea;

    @NotNull
    @Min(1)
    @Max(36)
    private Integer cuota;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(5|25){1}$", message = "Los valores días de pago debe ser 5 o 25")
    private String diapago;

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getDiapago() {
        return diapago;
    }

    public void setDiapago(String diapago) {
        this.diapago = diapago;
    }

    public Integer getCuota() { return cuota; }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMoneda() {  return moneda; }

    public void setMoneda(String moneda) { this.moneda = moneda; }

}
