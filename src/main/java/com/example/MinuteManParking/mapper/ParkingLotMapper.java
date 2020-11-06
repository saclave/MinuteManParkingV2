package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.ParkingLotRequest;
import com.example.MinuteManParking.dto.ParkingLotResponse;
import com.example.MinuteManParking.model.ParkingLot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingLotMapper {
    ParkingLotMapper PARKING_LOT_MAPPER = Mappers.getMapper(ParkingLotMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingSlotList", ignore = true)
    ParkingLot toEntity(ParkingLotRequest parkingLotRequest);

    @Mapping(target = "capacity", ignore = true)
    @Mapping(target = "available", ignore = true)
    ParkingLotResponse toResponse(ParkingLot parkingLot);
}
