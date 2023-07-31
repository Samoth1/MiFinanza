package com.tingeso.ingreso.controllers;

import com.tingeso.ingreso.entities.IngresoEntity;
import com.tingeso.ingreso.services.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    @Autowired
    IngresoService ingresoService;

    @GetMapping("/{fecha}")
    public ResponseEntity<IngresoEntity> obtenerIngreso(@PathVariable("fecha") Date fecha) {
        return ResponseEntity.ok(ingresoService.getIngreso(fecha));
    }

    @PostMapping()
    public ResponseEntity<?> guardarIngreso(@RequestBody IngresoEntity ingreso){
        ingresoService.createIngreso(ingreso.getFecha(), ingreso.getMotivo(), ingreso.getDinero());
        return ResponseEntity.ok().build();
    }
}
