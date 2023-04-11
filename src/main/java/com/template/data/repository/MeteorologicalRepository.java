package com.template.data.repository;

import com.template.data.entity.MeteorologicalEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeteorologicalRepository extends JpaRepository<MeteorologicalEntity, Long> {
    List<MeteorologicalEntity> findByCity(String city);
}
