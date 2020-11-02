package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.TransactionRequest;
import com.example.MinuteManParking.dto.TransactionResponse;
import com.example.MinuteManParking.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);

    Transaction toEntity(TransactionRequest transactionRequest);

    TransactionResponse toResponse(Transaction transaction);
}
