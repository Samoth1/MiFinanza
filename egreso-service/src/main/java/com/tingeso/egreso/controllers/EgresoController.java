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

    @GetMapping("/{num_doc}")
    public ResponseEntity<EgresoEntity> obtenerEgreso(@PathVariable("num_doc") String num_doc) {
        return ResponseEntity.ok(egresoService.getEgreso(num_doc));
    }

    @PostMapping()
    public ResponseEntity<?> guardarEgreso(@RequestBody EgresoEntity egreso) {
        egresoService.createEgreso(egreso.getFecha(), egreso.getTipodoc(), egreso.getNumdoc(), egreso.getMotivo(), egreso.getDinero());
        return ResponseEntity.ok().build();
    }

}
