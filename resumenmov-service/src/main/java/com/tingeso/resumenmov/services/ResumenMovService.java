package com.tingeso.resumenmov.services;

import com.tingeso.resumenmov.entities.ResumenMovEntity;
import com.tingeso.resumenmov.models.EgresoModel;
import com.tingeso.resumenmov.models.IngresoModel;
import com.tingeso.resumenmov.entities.ReporteEntity;
import com.tingeso.resumenmov.repositories.ResumenMovRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ResumenMovService {

    @Autowired
    private ResumenMovRepository resumenMovRepository;
    @Autowired
    RestTemplate restTemplate;

    // REST CONTROLLER PARA EGRESO
    public EgresoModel getEgreso(String num_doc){
        return restTemplate.getForObject("http://localhost:8083/egreso/"+ num_doc, EgresoModel.class);
    }

    // REST CONTROLLER PARA INGRESO
    public IngresoModel getIngreso(String num_doc){
        return restTemplate.getForObject("http://localhost:8082/ingreso/"+ num_doc, IngresoModel.class);
    }

    public void createResumen(Date fecha, String tipo_doc, String numero_doc, Integer movimiento) {
        ResumenMovEntity resumen = new ResumenMovEntity();
        Integer saldo = buscarSaldoActual() + movimiento;
        resumen.setFecha(fecha);
        resumen.setTipodoc(tipo_doc);
        resumen.setNumdoc(numero_doc);
        resumen.setSaldo(saldo);
        resumenMovRepository.save(resumen);
    }

    public Integer buscarSaldoActual(){
        ResumenMovEntity resumen = resumenMovRepository.findTopByOrderByIdDesc();
        return resumen.getSaldo();
    }

    public List<ResumenMovEntity> obtenerMovFecha(Date fecha1, Date fecha2){
        return resumenMovRepository.findByFechaBetween(fecha1, fecha2);
    }

    public List<ReporteEntity> getReporte(Date fecha1, Date fecha2){
        List<ReporteEntity> reporte = new ArrayList<ReporteEntity>();
        List<ResumenMovEntity> movimientos = obtenerMovFecha(fecha1, fecha2);

        for(ResumenMovEntity movimiento : movimientos){
            ReporteEntity resumen = new ReporteEntity();

            resumen.setFecha(movimiento.getFecha());
            resumen.setTipo_doc(movimiento.getTipodoc());
            resumen.setNum_doc(movimiento.getNumdoc());
            if (movimiento.getTipodoc().equals("Recibo")){
                IngresoModel ingreso = getIngreso(movimiento.getNumdoc());
                resumen.setMotivo(ingreso.getMotivo());
                resumen.setIngreso(ingreso.getDinero());
                resumen.setSalida(0);
            }
            else {
                EgresoModel egreso = getEgreso(movimiento.getNumdoc());
                resumen.setMotivo(egreso.getMotivo());
                resumen.setIngreso(0);
                resumen.setSalida(egreso.getDinero());
            }
            resumen.setSaldo(movimiento.getSaldo());

            reporte.add(resumen);
        }

        return reporte;
    }
}
