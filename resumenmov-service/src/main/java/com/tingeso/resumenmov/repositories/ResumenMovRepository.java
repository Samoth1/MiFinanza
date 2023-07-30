package com.tingeso.resumenmov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tingeso.resumenmov.entities.ResumenMovEntity;

@Repository
public interface ResumenMovRepository extends JpaRepository<ResumenMovEntity, Integer> {
}
