package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.CarRequest;
import com.example.MinuteManParking.dto.CarResponse;
import com.example.MinuteManParking.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "ticketList", ignore = true)
    @Mapping(target = "id", ignore = true)
    Car toEntity(CarRequest carRequest);

    CarResponse toResponse(Car car);
}
