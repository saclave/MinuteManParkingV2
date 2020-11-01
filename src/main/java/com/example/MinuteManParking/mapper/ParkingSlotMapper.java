package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.ParkingSlotRequest;
import com.example.MinuteManParking.dto.ParkingSlotResponse;
import com.example.MinuteManParking.model.ParkingSlot;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotMapper {
    public ParkingSlotResponse toResponse(ParkingSlot parkingSlot){
        ParkingSlotResponse parkingSlotResponse = new ParkingSlotResponse();
        BeanUtils.copyProperties(parkingSlot, parkingSlotResponse);
        return parkingSlotResponse;
    }

    public ParkingSlot toEntity(ParkingSlotRequest parkingSlotRequest){
        ParkingSlot parkingSlot = new ParkingSlot();
        BeanUtils.copyProperties(parkingSlotRequest, parkingSlot);
        return parkingSlot;
    }
}
