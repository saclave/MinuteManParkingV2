package com.example.MinuteManParking.repository;

import com.example.MinuteManParking.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
}
