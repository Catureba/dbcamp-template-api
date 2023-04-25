package com.template.data.repository;

import com.template.data.entity.MeteorologicalEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeteorologicalRepository extends JpaRepository<MeteorologicalEntity, Long> {
    List<MeteorologicalEntity> findByCity(String city);

}
