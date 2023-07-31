package com.tingeso.resumenmov.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReporteEntity {
    private Date fecha;
    private String tipo_doc;
    private String num_doc;
    private String motivo;
    private Integer ingreso;
    private Integer salida;
    private Integer saldo;
}
