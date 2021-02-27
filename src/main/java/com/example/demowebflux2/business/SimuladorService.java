package com.example.demowebflux2.business;

import com.example.demowebflux2.model.SimuladorRequest;
import com.example.demowebflux2.model.SimuladorResponse;

public interface SimuladorService {

    public boolean validarCondiciones(SimuladorRequest SimuladorRequest);

    public SimuladorResponse obtenerCuota(SimuladorRequest SimuladorRequest);

    public SimuladorResponse calcularCuota(SimuladorRequest simuladorRequest);
}
