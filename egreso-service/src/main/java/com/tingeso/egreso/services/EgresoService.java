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

    public void createEgreso(Date fecha, String documento, String motivo, Integer num_doc) {
        EgresoEntity egreso = new EgresoEntity();
        egreso.setFecha(fecha);
        egreso.setDocumento(documento);
        egreso.setMotivo(motivo);
        egreso.setNum_doc(num_doc);

        egresoRepository.save(egreso);
    }

    public EgresoEntity getEgreso(Date fecha){
        return egresoRepository.findByFecha(fecha);
    }

}
