package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carList", ignore = true)
    User toEntity(UserRequest transactionRequest);

    UserResponse toResponse(User user);
}
