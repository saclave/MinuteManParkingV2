package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.ParkingLotRequest;
import com.example.MinuteManParking.dto.ParkingLotResponse;
import com.example.MinuteManParking.model.ParkingLot;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    public ParkingLotResponse toResponse(ParkingLot parkingLot) {
        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        BeanUtils.copyProperties(parkingLot, parkingLotResponse);
        return parkingLotResponse;
    }

    public ParkingLot toEntity(ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = new ParkingLot();
        BeanUtils.copyProperties(parkingLotRequest, parkingLot);
        return parkingLot;
    }
}
