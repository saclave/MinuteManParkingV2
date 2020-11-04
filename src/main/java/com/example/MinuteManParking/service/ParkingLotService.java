package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.ParkingLotNotFound;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;

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
        retrieve(id);
        parkingLotRepository.deleteById(id);
    }

    public ParkingLot update(Integer id, ParkingLot parkingLot) {
        ParkingLot retrievedParkingLot = retrieve(id);
        retrievedParkingLot.setAddress(parkingLot.getAddress());
        retrievedParkingLot.setLatitude(parkingLot.getLatitude());
        retrievedParkingLot.setLongitude(parkingLot.getLongitude());
        retrievedParkingLot.setPrice(parkingLot.getPrice());
        retrievedParkingLot.setName(parkingLot.getName());
        retrievedParkingLot.setImgSrc(parkingLot.getImgSrc());
        return parkingLotRepository.save(retrievedParkingLot);
    }

    public List<ParkingSlot> getParkingSlotsByParkingLot(Integer id) {
        return parkingLotRepository.findById(id)
                .map(ParkingLot::getParkingSlotList)
                .orElseThrow(() -> new ParkingLotNotFound(PARKING_LOT_NOT_FOUND));
    }

    public String getImgSrc(Integer id) {
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElse(null);

        if(parkingLot != null){
            return parkingLot.getImgSrc();
        }
        return null;
    }
}
