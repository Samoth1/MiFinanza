package com.tingeso.ingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tingeso.ingreso.entities.IngresoEntity;

@Repository
public interface IngresoRepository extends JpaRepository<IngresoEntity, Integer> {
    IngresoEntity findByNumdoc(String num);
}
