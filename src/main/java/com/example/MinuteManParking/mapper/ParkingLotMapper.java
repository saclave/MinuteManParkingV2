package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.ParkingLotRequest;
import com.example.MinuteManParking.dto.ParkingLotResponse;
import com.example.MinuteManParking.model.ParkingLot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingLotMapper {
    ParkingLotMapper PARKING_LOT_MAPPER = Mappers.getMapper( ParkingLotMapper.class );

    ParkingLot toEntity(ParkingLotRequest parkingLotRequest);

    ParkingLotResponse toResponse(ParkingLot parkingLot);
}
