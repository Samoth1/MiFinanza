package com.tingeso.egreso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "data_egreso")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EgresoEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String documento;
    private String motivo;
    private Integer num_doc;

}
