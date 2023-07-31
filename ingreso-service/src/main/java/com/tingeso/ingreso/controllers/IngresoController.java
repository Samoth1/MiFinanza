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

    @GetMapping("/{num_doc}")
    public ResponseEntity<IngresoEntity> obtenerIngreso(@PathVariable("num_doc") String num_doc) {
        return ResponseEntity.ok(ingresoService.getIngreso(num_doc));
    }

    @PostMapping()
    public ResponseEntity<?> guardarIngreso(@RequestBody IngresoEntity ingreso){
        ingresoService.createIngreso(ingreso.getFecha(), ingreso.getMotivo(), ingreso.getDinero());
        return ResponseEntity.ok().build();
    }
}
