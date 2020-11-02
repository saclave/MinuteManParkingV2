package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.ParkingSlotNotFound;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;

@Service
public class ParkingSlotService {
    private ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public List<ParkingSlot> getAll() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot retrieve(Integer id) {
        return parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotNotFound(PARKING_SLOT_NOT_FOUND));
    }

    public ParkingSlot create(ParkingSlot parkingSlot) {
        return parkingSlotRepository.save(parkingSlot);
    }

    public void delete(Integer id) {
        parkingSlotRepository.deleteById(id);
    }

    public ParkingSlot update(Integer id, ParkingSlot parkingSlot) {
        ParkingSlot retrievedParkingSlot = retrieve(id);
        retrievedParkingSlot.setParkingLotId(parkingSlot.getParkingLotId());
        retrievedParkingSlot.setAvailability(parkingSlot.getAvailability());
        return parkingSlotRepository.save(retrievedParkingSlot);
    }

    public List<ParkingSlot> getParkingSlotsByParkingLot(Integer parkingLotId) {
        return parkingSlotRepository.findByParkingLotId(parkingLotId);
    }
}
