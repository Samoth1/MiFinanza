package com.tingeso.resumenmov.controllers;

import com.tingeso.resumenmov.entities.ResumenMovEntity;
import com.tingeso.resumenmov.entities.ReporteEntity;
import com.tingeso.resumenmov.services.ResumenMovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/resumenmov")
public class ResumenMovController {
    @Autowired
    ResumenMovService resumenMovService;

    @PostMapping()
    public ResponseEntity<?> guardarResumen(@RequestBody ResumenMovEntity resumen){
        resumenMovService.createResumen(resumen.getFecha(), resumen.getTipodoc(), resumen.getNumdoc(), resumen.getSaldo());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ReporteEntity> datosResumen(@RequestParam Date fecha1, @RequestParam Date fecha2){
        return resumenMovService.getReporte(fecha1, fecha2);
    }
}
