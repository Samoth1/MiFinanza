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

    public void createIngreso(Date fecha, String motivo) {
        IngresoEntity ingreso = new IngresoEntity();
        ingreso.setFecha(fecha);
        ingreso.setMotivo(motivo);

        ingresoRepository.save(ingreso);
    }

    public IngresoEntity getIngreso(Date fecha){
        return ingresoRepository.findByFecha(fecha);
    }

}
