package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.HazardRequest;
import com.example.MinuteManParking.dto.HazardResponse;
import com.example.MinuteManParking.model.Hazard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HazardMapper {
    HazardMapper HAZARD_MAPPER = Mappers.getMapper(HazardMapper.class);

    Hazard toEntity(HazardRequest hazardRequest);

    HazardResponse toResponse(Hazard hazard);
}
