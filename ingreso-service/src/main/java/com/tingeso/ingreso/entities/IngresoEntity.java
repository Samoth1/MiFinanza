package com.tingeso.ingreso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "data_ingreso")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngresoEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String motivo;
    private Integer dinero;
}
