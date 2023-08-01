package com.tingeso.resumenmov.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "data_resumen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResumenMovEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String tipodoc;
    private String numdoc;
    private Integer saldo;
}
