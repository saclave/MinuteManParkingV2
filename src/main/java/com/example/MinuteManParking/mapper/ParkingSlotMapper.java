package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.ParkingSlotRequest;
import com.example.MinuteManParking.dto.ParkingSlotResponse;
import com.example.MinuteManParking.model.ParkingSlot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingSlotMapper {
    ParkingSlotMapper PARKING_SLOT_MAPPER = Mappers.getMapper( ParkingSlotMapper.class );

    ParkingSlot toEntity(ParkingSlotRequest parkingLotRequest);

    ParkingSlotResponse toResponse(ParkingSlot parkingLot);
}
