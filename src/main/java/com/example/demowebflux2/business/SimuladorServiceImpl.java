package com.example.demowebflux2.business;

import com.example.demowebflux2.model.Condiciones;
import com.example.demowebflux2.model.Factor;
import com.example.demowebflux2.model.SimuladorRequest;
import com.example.demowebflux2.model.SimuladorResponse;
import com.example.demowebflux2.repository.CondicionesRepository;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SimuladorServiceImpl implements SimuladorService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CondicionesRepository CondicionesRepository;

    @Override
    public boolean validarCondiciones(SimuladorRequest simuladorRequest) {
        List<Condiciones> listaCondiciones = this.CondicionesRepository.findAll();
        /*
        logger.info("Condiciones para simulación:");
        for (Condiciones p : listaCondiciones) {
            System.out.println("***************** Condición *****************");
            System.out.println("getId:" + p.getId());
            System.out.println("getCuotamax:" + p.getCuotamax());
            System.out.println("getCuotamin:" + p.getCuotamin());
            System.out.println("getDiapago:" + p.getDiapago());
            System.out.println("getTea:" + p.getTea());
            System.out.println("getTarjeta:" + p.getTarjeta().getNombre());
            System.out.println("*********************************************");
        }
        */
        System.out.println("************Datos para simulación*********");
        System.out.println("DNI :" + simuladorRequest.getDni());
        System.out.println("MONEDA :" + simuladorRequest.getMoneda());
        System.out.println("TARJETA :" + simuladorRequest.getTarjeta());
        System.out.println("PAGO :" + simuladorRequest.getDiapago());
        System.out.println("CUOTA :" + simuladorRequest.getCuota());
        System.out.println("MONTO :" + simuladorRequest.getMonto());
        simuladorRequest.setTea(simuladorRequest.getTea().toString().substring(0,simuladorRequest.getTea().toString().length()-1));
        System.out.println("TEA :"+simuladorRequest.getTea().toString());
        System.out.println("*****************************************");

        List<Condiciones> CondicionesValidas = listaCondiciones.stream()
                .filter( x -> x.getCuotamax() >= simuladorRequest.getCuota())
                .filter( x -> x.getCuotamin() <= simuladorRequest.getCuota())
                     .filter( x -> x.getTarjeta().getNombre().equals(simuladorRequest.getTarjeta()))
                   .filter( x -> x.getDiapago()==Integer.valueOf((simuladorRequest.getDiapago())))
                     .filter( x -> x.getTea()== Double.parseDouble(simuladorRequest.getTea()))
                     .collect(Collectors.toList());

        CondicionesValidas.stream().forEach( x-> System.out.println("ID: "+x.getId()+" | Dia: "+x.getDiapago()+" | TEA: "+x.getTea()+" | Tarjeta: "+x.getTarjeta().getNombre()));
        System.out.println("Cantidad de Condición Valida :"+CondicionesValidas.size());

        if(CondicionesValidas.size()==1){
            return true;
        }else{
            return false;
        }

    }

    public LocalDate calfecha(LocalDate fecha, LocalDate primfecha){

        //SI( DIA(N2+30) = DIA($N$2);N2+30;N2+30- (DIA(N2+30)- DIA($N$2)))
        if(fecha.getDayOfMonth()+30 == primfecha.getDayOfMonth()){
            return fecha.plusDays(30);
        }else{
            return fecha.plusDays(30 - (fecha.getDayOfMonth()+30 - primfecha.getDayOfMonth()));
        }

    }
    @Override
    public SimuladorResponse calcularCuota(SimuladorRequest simuladorRequest) {
        double cuotas=simuladorRequest.getCuota();
        double monto=simuladorRequest.getMonto();
        Integer diapago=Integer.valueOf(simuladorRequest.getDiapago());
        double tea= Double.parseDouble(simuladorRequest.getTea().substring(0,simuladorRequest.getTea().length()-1));

        double ted = Math.pow(1+tea,(1/360)) - 1;
        int cantDiasPriCuo = diapago+  LocalDate.now().getDayOfMonth();
        double facpricuo = 1/Math.pow(1+ted,cantDiasPriCuo);
        double sumafactor=0.00;

        Factor factor= new Factor();
        LocalDate fec_act =LocalDate.now();
        List<Factor> listfactor = new ArrayList<>() ;
        for (int i = 0; i < cuotas-1; i++) {
            if (i==0) {
                factor.setFecha(fec_act.plusDays(30 + diapago));
                factor.setDia((int) DAYS.between(fec_act, factor.getFecha()));
                factor.setFactor(Math.round(1 / (Math.pow(1 + tea, factor.getDia() / 360))));

            }else{
                if(i==1){
                    factor.setFecha(calfecha(listfactor.get(0).getFecha(),listfactor.get(0).getFecha()));
                }else{
                    factor.setFecha(calfecha(listfactor.get(i-2).getFecha(),listfactor.get(i-1).getFecha()));
                }
                factor.setDia(((int) (DAYS.between(factor.getFecha(), listfactor.get(i-1).getFecha()))) +listfactor.get(i-1).getDia());
                factor.setFactor(Math.round(1 / (Math.pow(1 + tea, factor.getDia() / 360))));
            }
            listfactor.add(factor);
            sumafactor=sumafactor + factor.getFactor();
        }

        long cuotafinal = Math.round(monto /sumafactor);

        return new SimuladorResponse(cuotafinal,"S/",listfactor.get(0).getFecha(),"EXITO");

    }
    @Override
    public SimuladorResponse obtenerCuota(SimuladorRequest simuladorRequest) {
        if(this.validarCondiciones( simuladorRequest))
        {
            //Calculamos la cuota:
            SimuladorResponse cuota=this.calcularCuota(simuladorRequest);
            /*cuota.setCuota(simuladorRequest.getMonto()/simuladorRequest.getCuota());
            cuota.setMoneda(simuladorRequest.getMoneda());
            cuota.setEstado("EXITO");
            cuota.setPrimeracuota(LocalDate.now().plusDays(20));

             */
            return cuota;
        }else{
            return new SimuladorResponse();
        }

    }
}
