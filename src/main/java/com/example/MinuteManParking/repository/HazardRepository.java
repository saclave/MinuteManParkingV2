package com.example.MinuteManParking.repository;

import com.example.MinuteManParking.model.Hazard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HazardRepository extends JpaRepository<Hazard, Integer> {
    List<Hazard> findByType(String type);
}
