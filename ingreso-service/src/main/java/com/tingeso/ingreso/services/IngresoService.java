package com.tingeso.ingreso.services;

import com.tingeso.ingreso.entities.IngresoEntity;
import com.tingeso.ingreso.repositories.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IngresoService {
    @Autowired
    IngresoRepository ingresoRepository;

    public void createIngreso(Date fecha, String numero_doc, Integer dinero) {
        IngresoEntity ingreso = new IngresoEntity();
        ingreso.setFecha(fecha);
        ingreso.setTipodoc("Recibo");
        ingreso.setNumdoc(numero_doc);
        ingreso.setMotivo("Ingreso a Caja");
        ingreso.setDinero(dinero);
        ingresoRepository.save(ingreso);
    }

    public IngresoEntity getIngreso(String num){
        return ingresoRepository.findByNumdoc(num);
    }

}
