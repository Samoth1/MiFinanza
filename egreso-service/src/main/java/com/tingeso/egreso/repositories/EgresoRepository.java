package com.tingeso.egreso.repositories;

import com.tingeso.egreso.entities.EgresoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EgresoRepository extends JpaRepository<EgresoEntity, Integer> {
    EgresoEntity findByFecha(Date fecha);
}
