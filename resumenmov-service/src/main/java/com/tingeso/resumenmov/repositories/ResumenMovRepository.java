package com.tingeso.resumenmov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tingeso.resumenmov.entities.ResumenMovEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResumenMovRepository extends JpaRepository<ResumenMovEntity, Integer> {
    ResumenMovEntity findTopByOrderByIdDesc();
    List<ResumenMovEntity> findByFechaBetweenOrderByIdAsc(Date fecha1, Date fecha2);
}