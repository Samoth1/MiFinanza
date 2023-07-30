package com.tingeso.resumenmov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresoModel {
    private Date fecha;
    private String motivo;
}
