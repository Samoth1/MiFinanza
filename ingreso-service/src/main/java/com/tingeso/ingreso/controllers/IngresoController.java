package com.tingeso.ingreso.controllers;

import com.tingeso.ingreso.services.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    @Autowired
    IngresoService ingresoService;
}
