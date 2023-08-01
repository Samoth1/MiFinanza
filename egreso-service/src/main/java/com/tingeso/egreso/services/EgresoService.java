package com.tingeso.egreso.services;

import com.tingeso.egreso.entities.EgresoEntity;
import com.tingeso.egreso.repositories.EgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EgresoService {
    @Autowired
    private EgresoRepository egresoRepository;

    public void createEgreso(Date fecha, String tipo_doc, String numero_doc, String motivo, Integer dinero) {
        EgresoEntity egreso = new EgresoEntity();
        egreso.setFecha(fecha);
        egreso.setTipodoc(tipo_doc);
        egreso.setNumdoc(numero_doc);
        egreso.setMotivo(motivo);
        egreso.setDinero(dinero);
        egresoRepository.save(egreso);
    }

    public EgresoEntity getEgreso(String num){
        System.out.print(num);
        EgresoEntity egresin = egresoRepository.findByNumdoc(num);
        System.out.print(egresin);
        return egresin;
    }

}
