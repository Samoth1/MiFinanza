package com.tingeso.resumenmov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EgresoModel {
    private Date fecha;
    private String documento;
    private String motivo;
    private Integer num_doc;
}
