package com.example.MinuteManParking.service;

import com.example.MinuteManParking.advice.ParkingLotNotFound;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.advice.ParkingLotNotFound.PARKING_LOT_NOT_FOUND;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<ParkingLot> getAll() {
        return parkingLotRepository.findAll();
    }

    public ParkingLot retrieve(Integer id) {
        return parkingLotRepository.findById(id)
                .orElseThrow(() -> new ParkingLotNotFound(PARKING_LOT_NOT_FOUND));
    }

    public ParkingLot create(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public void delete(Integer id) {
        parkingLotRepository.deleteById(id);
    }

    public ParkingLot update(Integer id, ParkingLot parkingLot) {
        ParkingLot retrievedParkingLot = retrieve(id);
        retrievedParkingLot.setAddress(parkingLot.getAddress());
        retrievedParkingLot.setLatitude(parkingLot.getLatitude());
        retrievedParkingLot.setLongitude(parkingLot.getLongitude());
        retrievedParkingLot.setPrice(parkingLot.getPrice());
        return parkingLotRepository.save(retrievedParkingLot);
    }
}
