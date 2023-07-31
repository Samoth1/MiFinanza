package com.tingeso.egreso.controllers;

import com.tingeso.egreso.entities.EgresoEntity;
import com.tingeso.egreso.services.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@RestController
@RequestMapping("/egreso")
public class EgresoController {
    @Autowired
    EgresoService egresoService;

    @GetMapping("/{fecha}")
    public ResponseEntity<EgresoEntity> obtenerEgreso(@PathVariable("fecha") Date fecha) {
        return ResponseEntity.ok(egresoService.getEgreso(fecha));
    }

    @PostMapping()
    public ResponseEntity<?> guardarEgreso(@RequestBody EgresoEntity egreso){
        egresoService.createEgreso(egreso.getFecha(), egreso.getDocumento(), egreso.getMotivo(), egreso.getNum_doc(), egreso.getDinero());
        return ResponseEntity.ok().build();
    }
}
